package com.github.core.domain.github

import com.github.core.data.remote.api.model.userSearch.UserSearchResponse
import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import javax.inject.Inject

class UserSearchUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : UseCase<UserSearchResponse?, UserSearchUseCase.Params>() {

    data class Params(val query: String)

    override suspend fun invoke(params: Params?) = githubRepository.userSearch(params?.query)
}
