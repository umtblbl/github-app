package com.github.dynamicfeatures.userdetail.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.userdetail.domain.AddFavoriteUserUseCase
import com.github.dynamicfeatures.userdetail.domain.DeleteFavoriteUserUseCase
import com.github.dynamicfeatures.userdetail.domain.UserDetailUseCase
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase: UserDetailUseCase,
    private val addFavoriteUserUseCase: AddFavoriteUserUseCase,
    private val deleteFavoriteUserUseCase: DeleteFavoriteUserUseCase
) : ViewModel() {

    val itemUserDetailData = MutableLiveData<ItemUserDetail>()
    val favoriteActionResultData = MutableLiveData<Pair<ItemUserDetail?, Boolean>?>()

    suspend fun userDetail(userName: String?) =
        itemUserDetailData.postValue(
            userDetailUseCase.invoke(UserDetailUseCase.Params(userName))
        )

    suspend fun handleFavoriteSelection(model: ItemUserDetail?) {
        model ?: return
        if (model.isFavorite) deleteFavoriteUser(model)
        else addFavoriteUser(model)
    }

    private suspend fun addFavoriteUser(model: ItemUserDetail?) {
        val result = addFavoriteUserUseCase.invoke(
            AddFavoriteUserUseCase.Params(model)
        )
        favoriteActionResultData.postValue(Pair(model, result))
    }

    private suspend fun deleteFavoriteUser(model: ItemUserDetail?) {
        val result = deleteFavoriteUserUseCase.invoke(
            DeleteFavoriteUserUseCase.Params(model)
        )
        favoriteActionResultData.postValue(Pair(model, result))
    }
}
