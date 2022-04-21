package com.github.dynamicfeatures.usersearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.usersearch.domain.AddFavoriteUserUseCase
import com.github.dynamicfeatures.usersearch.domain.UserSearchUseCase
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserSearchViewModel @Inject constructor(
    private val userSearchUseCase: UserSearchUseCase,
    private val addFavoriteUserUseCase: AddFavoriteUserUseCase
) : ViewModel() {

    val favoriteActionResultData = MutableLiveData<Boolean>()

    suspend fun userSearch(query: String) = flow {
        emit(userSearchUseCase.invoke(UserSearchUseCase.Params(query)))
    }

    suspend fun addFavoriteUser(itemUserModel: ItemUserModel?) {
        val result = addFavoriteUserUseCase.invoke(
            AddFavoriteUserUseCase.Params(itemUserModel)
        )
        favoriteActionResultData.postValue(result)
    }
}
