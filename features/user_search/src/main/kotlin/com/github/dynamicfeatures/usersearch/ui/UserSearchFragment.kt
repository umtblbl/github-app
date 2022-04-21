package com.github.dynamicfeatures.usersearch.ui

import android.os.Build
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.github.android.GithubApp
import com.github.commons.ui.adapter.RecyclerViewBasicAdapter
import com.github.commons.ui.base.BaseFragment
import com.github.commons.ui.extension.changes
import com.github.commons.ui.extension.showKeyboard
import com.github.dynamicfeatures.usersearch.BR
import com.github.dynamicfeatures.usersearch.Configs
import com.github.dynamicfeatures.usersearch.R
import com.github.dynamicfeatures.usersearch.databinding.FragmentUserSearchBinding
import com.github.dynamicfeatures.usersearch.di.DaggerUserSearchComponent
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
    }

    //region private functions

    private fun initUserRecyclerView() {
        adapter = RecyclerViewBasicAdapter(
            layoutId = R.layout.item_user,
            bindingModelName = BR.model
        ) {
        }
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
                    return@filter searchItem?.text?.isNotEmpty() ?: false
                }
                .distinctUntilChanged()
                .flatMapLatest { searchItem ->
                    if (searchItem?.isSubmit == true) binding.userSearchView.clearFocus()
                    viewModel.userSearch(searchItem?.text ?: "")
                }.collect { result ->
                    withContext(Dispatchers.Main) {
                        adapter.list = result
                    }
                }
        }
    }

    //endregion
}