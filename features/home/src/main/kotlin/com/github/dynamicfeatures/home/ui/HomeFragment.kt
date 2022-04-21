package com.github.dynamicfeatures.home.ui

import android.os.Bundle
import android.view.View
import com.github.android.GithubApp
import com.github.commons.ui.extension.setupWithNavController
import com.github.commons.ui.base.BaseFragment
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
        binding.viewModel = viewModel
        setupBottomNavigationBar()
    }

    //region Private Functions

    private fun setupBottomNavigationBar() {
        binding.bottomNavigation.setupWithNavController(
            navGraphIds = listOf(
                R.navigation.navigation_user_search_graph,
                R.navigation.navigation_user_favorites_graph
            ),
            fragmentManager = childFragmentManager,
            containerId = R.id.navHostContainer,
            intent = requireActivity().intent
        ).let { navController ->
            navController.observe(viewLifecycleOwner) {
                viewModel.navigationControllerChanged(it)
            }
        }
    }

    //endregion
}
