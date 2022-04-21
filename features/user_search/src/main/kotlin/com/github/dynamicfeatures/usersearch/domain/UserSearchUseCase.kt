package com.github.dynamicfeatures.usersearch.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.usersearch.mapper.UserSearchMapper
import com.github.dynamicfeatures.usersearch.mapper.UserSearchMapperInput
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import javax.inject.Inject

class UserSearchUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    private val userSearchMapper: UserSearchMapper
) : UseCase<List<ItemUserModel>?, UserSearchUseCase.Params>() {

    data class Params(val query: String)

    override suspend fun invoke(params: Params?) =
        userSearchMapper.map(
            UserSearchMapperInput(
                userSearchResponse = githubRepository.userSearch(params?.query),
                favoriteUsers = githubRepository.getAllFavoriteUser()
            )
        )
}
