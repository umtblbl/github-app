package com.github.dynamicfeatures.home.ui

import androidx.lifecycle.ViewModel
import com.github.core.domain.github.UserSearchUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val userSearchUseCase: UserSearchUseCase
): ViewModel()
