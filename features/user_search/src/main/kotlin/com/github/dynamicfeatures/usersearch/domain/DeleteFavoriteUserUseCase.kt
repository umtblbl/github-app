package com.github.dynamicfeatures.usersearch.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import javax.inject.Inject

class DeleteFavoriteUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : UseCase<Boolean, DeleteFavoriteUserUseCase.Params>() {

    data class Params(val model: ItemUserModel?)

    override suspend fun invoke(params: Params?) =
        githubRepository.deleteFavoriteUser(userName = params?.model?.userName)
}
