package com.github.dynamicfeatures.usersearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.usersearch.domain.*
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserSearchViewModel @Inject constructor(
    private val userSearchUseCase: UserSearchUseCase,
    private val addFavoriteUserUseCase: AddFavoriteUserUseCase,
    private val deleteFavoriteUserUseCase: DeleteFavoriteUserUseCase,
    private val getAllSearchUserUseCase: GetAllSearchUserUseCase,
    private val addSearchUserUseCase: AddSearchUserUseCase
) : ViewModel() {

    val favoriteActionResultData = MutableLiveData<Pair<ItemUserModel?, Boolean>?>()
    val itemUserModelsData = MutableLiveData<List<ItemUserModel>>()

    suspend fun lastSearchedUsers() = itemUserModelsData.postValue(
        getAllSearchUserUseCase.invoke(null)
    )

    suspend fun searchQuery(query: String?) {
        userSearch(query ?: return)
            .collect {
                itemUserModelsData.postValue(it)
                addSearchUserUseCase.invoke(AddSearchUserUseCase.Params(it))
            }
    }

    suspend fun handleFavoriteSelection(model: ItemUserModel?) {
        model ?: return
        if (model.isFavorite) deleteFavoriteUser(model)
        else addFavoriteUser(model)
    }

    //region Private Functions

    private suspend fun userSearch(query: String) = flow {
        emit(userSearchUseCase.invoke(UserSearchUseCase.Params(query)))
    }

    private suspend fun addFavoriteUser(model: ItemUserModel?) {
        val result = addFavoriteUserUseCase.invoke(
            AddFavoriteUserUseCase.Params(model)
        )
        favoriteActionResultData.postValue(Pair(model, result))
    }

    private suspend fun deleteFavoriteUser(model: ItemUserModel?) {
        val result = deleteFavoriteUserUseCase.invoke(
            DeleteFavoriteUserUseCase.Params(model)
        )
        favoriteActionResultData.postValue(Pair(model, result))
    }

    //endregion
}
