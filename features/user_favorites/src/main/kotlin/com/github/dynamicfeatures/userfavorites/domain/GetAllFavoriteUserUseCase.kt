package com.github.dynamicfeatures.userfavorites.domain

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.UseCase
import com.github.dynamicfeatures.userfavorites.mapper.GetAllFavoriteUserMapper
import com.github.dynamicfeatures.userfavorites.ui.model.ItemUserModel
import javax.inject.Inject

class GetAllFavoriteUserUseCase @Inject constructor(
    private val githubRepository: GithubRepository,
    private val getAllFavoriteUserMapper: GetAllFavoriteUserMapper
) : UseCase<List<ItemUserModel>, GetAllFavoriteUserUseCase.Params>() {

    data class Params(val model: None? = null)

    override suspend fun invoke(params: Params?) =
        getAllFavoriteUserMapper.map(githubRepository.getAllFavoriteUser())
}
