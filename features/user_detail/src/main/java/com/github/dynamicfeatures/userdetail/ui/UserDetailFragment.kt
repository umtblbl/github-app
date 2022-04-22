package com.github.dynamicfeatures.userdetail.ui

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.android.GithubApp
import com.github.commons.ui.base.BaseFragment
import com.github.dynamicfeatures.userdetail.R
import com.github.dynamicfeatures.userdetail.databinding.FragmentUserDetailBinding
import com.github.dynamicfeatures.userdetail.di.DaggerUserDetailComponent
import com.github.dynamicfeatures.userdetail.ui.type.ToastType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailFragment(
    override val layoutResId: Int = R.layout.fragment_user_detail
) : BaseFragment<UserDetailViewModel, FragmentUserDetailBinding>(UserDetailViewModel::class) {

    private val args: UserDetailFragmentArgs by navArgs()

    override fun initDI() {
        DaggerUserDetailComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
        listenFavoriteActionResult()
        listenItemUserDetailData()
        uiScope.launch(Dispatchers.IO) {
            viewModel.userDetail(args.userName)
        }
        binding.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.favoriteImageView.setOnClickListener {
            uiScope.launch(Dispatchers.IO) {
                viewModel.handleFavoriteSelection(binding.model)
            }
        }
    }

    //region Private Functions

    private fun listenItemUserDetailData() {
        viewModel.itemUserDetailData.observe(this) { userDetail ->
            binding.model = userDetail
                .apply {
                    isFavorite = args.isFavorite
                }
        }
    }

    private fun listenFavoriteActionResult() {
        viewModel.favoriteActionResultData.observe(this) { pair ->
            pair?.let {
                val itemUserDetailModel = it.first
                val isSuccess = it.second

                if (isSuccess) {
                    binding.model = itemUserDetailModel
                        ?.apply {
                            this.isFavorite = !this.isFavorite
                        }
                    Toast.makeText(
                        context,
                        context?.getString(ToastType.ProcessSuccessful.titleResId),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        viewModel.favoriteActionResultData.postValue(null)
    }

    //endregion
}