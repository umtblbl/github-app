package com.github.dynamicfeatures.usersearch.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.usersearch.mapper.AddSearchUserMapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel
import javax.inject.Inject

class AddSearchUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    private val addSearchUserMapper: AddSearchUserMapper
) : UseCase<Boolean, AddSearchUserUseCase.Params>() {

    data class Params(val models: List<ItemUserModel>?)

    override suspend fun invoke(params: Params?) =
        githubRepository.addSearchUser(addSearchUserMapper.map(params?.models))
}
