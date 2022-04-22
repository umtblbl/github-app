package com.github.dynamicfeatures.usersearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.core.domain.UseCase
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

    val favoriteActionResultData = MutableLiveData<Pair<ItemUserModel?, Boolean>>()
    val itemUserModels = MutableLiveData<List<ItemUserModel>>()

    suspend fun getLastSearchedUsers() =
        itemUserModels.postValue(getAllSearchUserUseCase.invoke(null))

    suspend fun searchQuery(query: String?) {
        userSearch(query ?: return)
            .collect {
                itemUserModels.postValue(it)
                addSearchUserUseCase.invoke(AddSearchUserUseCase.Params(it))
            }
    }

    suspend fun handleFavoriteSelection(itemUserModel: ItemUserModel?) {
        itemUserModel ?: return
        if (itemUserModel.isFavorite) deleteFavoriteUser(itemUserModel)
        else addFavoriteUser(itemUserModel)
    }

    //region Private Functions

    private suspend fun userSearch(query: String) = flow {
        emit(userSearchUseCase.invoke(UserSearchUseCase.Params(query)))
    }

    private suspend fun addFavoriteUser(itemUserModel: ItemUserModel?) {
        val result = addFavoriteUserUseCase.invoke(
            AddFavoriteUserUseCase.Params(itemUserModel)
        )
        favoriteActionResultData.postValue(Pair(itemUserModel, result))
    }

    private suspend fun deleteFavoriteUser(itemUserModel: ItemUserModel?) {
        val result = deleteFavoriteUserUseCase.invoke(
            DeleteFavoriteUserUseCase.Params(itemUserModel)
        )
        favoriteActionResultData.postValue(Pair(itemUserModel, result))
    }

    //endregion
}
