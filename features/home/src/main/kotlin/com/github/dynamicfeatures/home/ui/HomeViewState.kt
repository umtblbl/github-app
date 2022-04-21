package com.github.dynamicfeatures.home.ui

import com.github.commons.ui.base.BaseViewState

sealed class HomeViewState : BaseViewState {

    object FullScreen : HomeViewState()

    object NavigationScreen : HomeViewState()

    val isFullScreen: Boolean get() = this is FullScreen

    val isNavigationScreen: Boolean get() = this is NavigationScreen
}
