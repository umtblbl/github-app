package com.github.dynamicfeatures.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.github.dynamicfeatures.home.R
import javax.inject.Inject

val NAV_FRAGMENTS_ID = setOf(R.id.user_search_fragment, R.id.user_favorites_fragment)

class HomeViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableLiveData<HomeViewState>()
    val state: LiveData<HomeViewState>
        get() = _state

    fun navigationControllerChanged(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (NAV_FRAGMENTS_ID.contains(destination.id)) {
                _state.postValue(HomeViewState.NavigationScreen)
            } else {
                _state.postValue(HomeViewState.FullScreen)
            }
        }
    }
}
