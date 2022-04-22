package com.github.dynamicfeatures.userdetail.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail
import javax.inject.Inject

class DeleteFavoriteUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : UseCase<Boolean, DeleteFavoriteUserUseCase.Params>() {

    data class Params(val model: ItemUserDetail?)

    override suspend fun invoke(params: Params?) =
        githubRepository.deleteFavoriteUser(userName = params?.model?.userName)
}
