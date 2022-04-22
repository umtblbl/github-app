package com.github.dynamicfeatures.userfavorites.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.userfavorites.domain.DeleteFavoriteUserUseCase
import com.github.dynamicfeatures.userfavorites.domain.GetAllFavoriteUserUseCase
import com.github.dynamicfeatures.userfavorites.ui.model.ItemUserModel
import javax.inject.Inject

class UserFavoritesViewModel @Inject constructor(
    private val getAllFavoriteUserUseCase: GetAllFavoriteUserUseCase,
    private val deleteFavoriteUserUseCase: DeleteFavoriteUserUseCase
) : ViewModel() {

    val favoriteActionResultData = MutableLiveData<Pair<ItemUserModel?, Boolean>?>()
    val itemUserModelsData = MutableLiveData<List<ItemUserModel>>()

    suspend fun allFavoriteUsers() = itemUserModelsData.postValue(
        getAllFavoriteUserUseCase.invoke(null)
    )

    suspend fun handleFavoriteSelection(itemUserModel: ItemUserModel?) {
        itemUserModel ?: return
        if (itemUserModel.isFavorite)
            deleteFavoriteUser(itemUserModel)
    }

    private suspend fun deleteFavoriteUser(itemUserModel: ItemUserModel?) {
        val result = deleteFavoriteUserUseCase.invoke(
            DeleteFavoriteUserUseCase.Params(itemUserModel)
        )
        favoriteActionResultData.postValue(Pair(itemUserModel, result))
    }
}