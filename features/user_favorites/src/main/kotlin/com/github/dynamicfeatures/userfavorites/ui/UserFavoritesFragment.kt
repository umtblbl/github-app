package com.github.dynamicfeatures.userfavorites.ui

import com.github.android.GithubApp
import com.github.commons.ui.base.BaseFragment
import com.github.dynamicfeatures.userfavorites.R
import com.github.dynamicfeatures.userfavorites.databinding.FragmentUserFavoritesBinding
import com.github.dynamicfeatures.userfavorites.di.DaggerUserFavoritesComponent

class UserFavoritesFragment(
    override val layoutResId: Int = R.layout.fragment_user_favorites
) : BaseFragment<UserFavoritesViewModel, FragmentUserFavoritesBinding>(UserFavoritesViewModel::class) {
    override fun initDI() {
        DaggerUserFavoritesComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
    }
}