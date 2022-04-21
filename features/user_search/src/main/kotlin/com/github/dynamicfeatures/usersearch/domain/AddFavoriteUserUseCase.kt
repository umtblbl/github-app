package com.github.dynamicfeatures.usersearch.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import javax.inject.Inject

class AddFavoriteUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : UseCase<Boolean, AddFavoriteUserUseCase.Params>() {

    data class Params(val model: ItemUserModel?)

    override suspend fun invoke(params: Params?) =
        githubRepository.addFavoriteUser(
            userName = params?.model?.userName,
            avatarUrl = params?.model?.avatarUrl
        )
}
