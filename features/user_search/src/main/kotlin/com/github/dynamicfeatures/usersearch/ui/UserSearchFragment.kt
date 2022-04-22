package com.github.dynamicfeatures.usersearch.ui

import android.os.Build
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.github.android.GithubApp
import com.github.commons.ui.adapter.RecyclerViewBasicAdapter
import com.github.commons.ui.base.BaseFragment
import com.github.commons.ui.extension.changes
import com.github.commons.ui.extension.showKeyboard
import com.github.dynamicfeatures.usersearch.BR
import com.github.dynamicfeatures.usersearch.Configs
import com.github.dynamicfeatures.usersearch.R
import com.github.dynamicfeatures.usersearch.databinding.FragmentUserSearchBinding
import com.github.dynamicfeatures.usersearch.databinding.ItemUserBinding
import com.github.dynamicfeatures.usersearch.di.DaggerUserSearchComponent
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import com.github.dynamicfeatures.usersearch.ui.type.ToastType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserSearchFragment(
    override val layoutResId: Int = R.layout.fragment_user_search
) : BaseFragment<UserSearchViewModel, FragmentUserSearchBinding>(UserSearchViewModel::class) {

    private var adapter: RecyclerViewBasicAdapter<ItemUserModel>
        get() = binding.userRecyclerView.adapter as RecyclerViewBasicAdapter<ItemUserModel>
        set(value) {
            binding.userRecyclerView.adapter = value
        }

    override fun initDI() {
        DaggerUserSearchComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
        initUserRecyclerView()
        customizeSearchView()
        listenUserSearchView()
        listenFavoriteActionResult()
        listenItemUserModels()
        uiScope.launch(Dispatchers.IO) { viewModel.lastSearchedUsers() }
    }

    //region private functions

    private fun listenItemUserModels() {
        uiScope.launch(Dispatchers.Main) {
            viewModel.itemUserModelsData.observe(viewLifecycleOwner) { itemUserModels ->
                adapter.list = itemUserModels
            }
        }
    }

    private fun listenFavoriteActionResult() {
        viewModel.favoriteActionResultData.observe(this) { pair ->
            pair?.let {
                val itemUserModel = it.first
                val isSuccess = it.second

                if (isSuccess) {
                    adapter.list = adapter.list.apply {
                        this.firstOrNull { it == itemUserModel }
                            ?.apply { this.isFavorite = !this.isFavorite }
                    }
                    Toast.makeText(
                        context,
                        context?.getString(ToastType.ProcessSuccessful.titleResId),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            viewModel.favoriteActionResultData.postValue(null)
        }
    }

    private fun initUserRecyclerView() {
        adapter = RecyclerViewBasicAdapter(
            layoutId = R.layout.item_user,
            bindingModelName = BR.model,
            itemSelected = { itemUserModel ->
                itemUserModel.userName?.let {
                    findNavController().navigate(
                        UserSearchFragmentDirections
                            .actionUserSearchFragmentToUserDetailFragment(it)
                    )
                }
            },
            bindHandler = { viewDataBinding, model ->
                (viewDataBinding as? ItemUserBinding)
                    ?.favoriteImageView
                    ?.setOnClickListener {
                        uiScope.launch(Dispatchers.IO) {
                            viewModel.handleFavoriteSelection(model as? ItemUserModel)
                        }
                    }
            }
        )
    }

    private fun customizeSearchView() {
        binding.userSearchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            .apply {
                ContextCompat.getColor(requireContext(), R.color.white)
                    .let { color ->
                        setTextColor(color)
                        setHintTextColor(color)
                    }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    setTextCursorDrawable(R.drawable.edittext_cursor_bg)
                }

                binding.userSearchView.setOnClickListener {
                    binding.userSearchView.isIconified = false
                    context.showKeyboard(this)
                }
            }
    }

    @OptIn(ExperimentalCoroutinesApi::class, kotlinx.coroutines.FlowPreview::class)
    private fun listenUserSearchView() {
        uiScope.launch(Dispatchers.IO) {
            binding.userSearchView
                .changes()
                .debounce(Configs.Search.TIME_OUT_MILLIS)
                .filter { searchItem ->
                    return@filter !searchItem?.text.isNullOrBlank()
                }.collect { searchItem ->
                    if (searchItem?.isSubmit == true) binding.userSearchView.clearFocus()
                    viewModel.searchQuery(searchItem?.text)
                }
        }
    }

    //endregion
}