package com.github.dynamicfeatures.userdetail.domain

import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail
import javax.inject.Inject

class AddFavoriteUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : UseCase<Boolean, AddFavoriteUserUseCase.Params>() {

    data class Params(val model: ItemUserDetail?)

    override suspend fun invoke(params: Params?): Boolean {
        params?.model?.userName ?: return false
        params.model.avatarUrl ?: return false

        return githubRepository.addFavoriteUser(
            listOf(
                FavoriteUserEntity(
                    userName = params.model.userName,
                    avatarUrl = params.model.avatarUrl
                )
            )
        )
    }
}
