package com.github.dynamicfeatures.userfavorites.ui

import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.github.android.GithubApp
import com.github.commons.ui.adapter.RecyclerViewBasicAdapter
import com.github.commons.ui.base.BaseFragment
import com.github.dynamicfeatures.userfavorites.BR
import com.github.dynamicfeatures.userfavorites.R
import com.github.dynamicfeatures.userfavorites.databinding.FragmentUserFavoritesBinding
import com.github.dynamicfeatures.userfavorites.databinding.ItemUserBinding
import com.github.dynamicfeatures.userfavorites.di.DaggerUserFavoritesComponent
import com.github.dynamicfeatures.userfavorites.ui.model.ItemUserModel
import com.github.dynamicfeatures.userfavorites.ui.type.ToastType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserFavoritesFragment(
    override val layoutResId: Int = R.layout.fragment_user_favorites
) : BaseFragment<UserFavoritesViewModel, FragmentUserFavoritesBinding>(UserFavoritesViewModel::class) {

    private var adapter: RecyclerViewBasicAdapter<ItemUserModel>
        get() = binding.userRecyclerView.adapter as RecyclerViewBasicAdapter<ItemUserModel>
        set(value) {
            binding.userRecyclerView.adapter = value
        }

    override fun initDI() {
        DaggerUserFavoritesComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
        initUserRecyclerView()
        listenItemUserModels()
        listenFavoriteActionResult()
        uiScope.launch(Dispatchers.IO) { viewModel.allFavoriteUsers() }
    }

    //region private functions

    private fun listenFavoriteActionResult() {
        viewModel.favoriteActionResultData.observe(this) { pair ->
            pair?.let {
                val itemUserModel = pair.first
                val isSuccess = pair.second

                if (isSuccess) {
                    adapter.list = adapter.list.toMutableList()
                        .apply {
                            remove(firstOrNull { it.userName == itemUserModel?.userName })
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
                        UserFavoritesFragmentDirections
                            .actionUserFavoritesFragmentToUserDetailFragment(
                                userName = it,
                                isFavorite = itemUserModel.isFavorite
                            )
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


    private fun listenItemUserModels() {
        uiScope.launch(Dispatchers.Main) {
            viewModel.itemUserModelsData.observe(viewLifecycleOwner) { itemUserModels ->
                adapter.list = itemUserModels
            }
        }
    }
}