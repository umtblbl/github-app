package com.github.dynamicfeatures.usersearch.ui

import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.usersearch.domain.UserSearchUseCase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserSearchViewModel @Inject constructor(
    private val userSearchUseCase: UserSearchUseCase
) : ViewModel() {

    suspend fun userSearch(query: String) = flow {
        emit(userSearchUseCase.invoke(UserSearchUseCase.Params(query)))
    }
}
