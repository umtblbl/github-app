package com.github.dynamicfeatures.home.ui

import com.github.android.GithubApp
import com.github.commons.ui.BaseFragment
import com.github.dynamicfeatures.home.R
import com.github.dynamicfeatures.home.databinding.FragmentHomeBinding
import com.github.dynamicfeatures.home.di.DaggerHomeComponent

class HomeFragment(
    override val layoutResId: Int = R.layout.fragment_home
) : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class) {

    override fun initDI() {
        DaggerHomeComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
    }
}
