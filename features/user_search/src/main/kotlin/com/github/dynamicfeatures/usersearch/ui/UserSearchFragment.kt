package com.github.dynamicfeatures.usersearch.ui

import com.github.android.GithubApp
import com.github.commons.ui.base.BaseFragment
import com.github.dynamicfeatures.usersearch.R
import com.github.dynamicfeatures.usersearch.databinding.FragmentUserSearchBinding
import com.github.dynamicfeatures.usersearch.di.DaggerUserSearchComponent

class UserSearchFragment(
    override val layoutResId: Int = R.layout.fragment_user_search
) : BaseFragment<UserSearchViewModel, FragmentUserSearchBinding>(UserSearchViewModel::class) {

    override fun initDI() {
        DaggerUserSearchComponent
            .builder()
            .coreComponent(GithubApp.coreComponent(requireContext()))
            .build()
            .inject(this)
    }

    override fun setupView() {
    }
}