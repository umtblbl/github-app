package com.github.dynamicfeatures.userdetail.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.dynamicfeatures.userdetail.domain.UserDetailUseCase
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase: UserDetailUseCase
) : ViewModel() {

    val itemUserDetailData = MutableLiveData<ItemUserDetail>()

    suspend fun userDetail(userName: String?) =
        itemUserDetailData.postValue(
            userDetailUseCase.invoke(UserDetailUseCase.Params(userName))
        )
}
