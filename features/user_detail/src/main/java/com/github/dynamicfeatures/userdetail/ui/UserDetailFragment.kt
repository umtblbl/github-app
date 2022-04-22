package com.github.dynamicfeatures.userdetail.ui

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.android.GithubApp
import com.github.commons.ui.base.BaseFragment
import com.github.dynamicfeatures.userdetail.R
import com.github.dynamicfeatures.userdetail.databinding.FragmentUserDetailBinding
import com.github.dynamicfeatures.userdetail.di.DaggerUserDetailComponent
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
        uiScope.launch(Dispatchers.IO) {
            viewModel.userDetail(args.userName)
        }
        viewModel.itemUserDetailData.observe(this) { userDetail ->
            binding.model = userDetail
        }
        binding.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}