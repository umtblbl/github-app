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

    suspend fun handleFavoriteSelection(model: ItemUserModel?) {
        model ?: return
        if (model.isFavorite)
            deleteFavoriteUser(model)
    }

    private suspend fun deleteFavoriteUser(model: ItemUserModel?) {
        val result = deleteFavoriteUserUseCase.invoke(
            DeleteFavoriteUserUseCase.Params(model)
        )
        favoriteActionResultData.postValue(Pair(model, result))
    }
}