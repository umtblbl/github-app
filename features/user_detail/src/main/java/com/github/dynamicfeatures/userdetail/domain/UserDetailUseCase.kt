package com.github.dynamicfeatures.userdetail.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.userdetail.mapper.UserDetailMapper
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail
import javax.inject.Inject

class UserDetailUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    private val userDetailMapper: UserDetailMapper
) : UseCase<ItemUserDetail?, UserDetailUseCase.Params>() {

    data class Params(val userName: String?)

    override suspend fun invoke(params: Params?) =
        userDetailMapper.map(
            githubRepository.userDetail(userName = params?.userName)
        )
}
