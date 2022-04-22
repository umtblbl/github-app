package com.github.dynamicfeatures.usersearch.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.usersearch.mapper.GetAllSearchUserMapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import javax.inject.Inject

class GetAllSearchUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    private val getAllSearchUserMapper: GetAllSearchUserMapper
) : UseCase<List<ItemUserModel>, GetAllSearchUserUseCase.Params>() {

    data class Params(val model: None? = null)

    override suspend fun invoke(params: Params?) =
        getAllSearchUserMapper.map(githubRepository.getAllSearchUser())
}
