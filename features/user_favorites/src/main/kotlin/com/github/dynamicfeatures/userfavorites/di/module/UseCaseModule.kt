package com.github.dynamicfeatures.userfavorites.di.module

import com.github.core.data.repository.GithubRepository
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userfavorites.domain.DeleteFavoriteUserUseCase
import com.github.dynamicfeatures.userfavorites.domain.GetAllFavoriteUserUseCase
import com.github.dynamicfeatures.userfavorites.mapper.GetAllFavoriteUserMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun provideGetAllFavoriteUserUseCase(
        githubRepository: GithubRepository,
        getAllFavoriteUserMapper: GetAllFavoriteUserMapper
    ) = GetAllFavoriteUserUseCase(githubRepository, getAllFavoriteUserMapper)

    @FeatureScope
    @Provides
    fun provideDeleteFavoriteUserUseCase(
        githubRepository: GithubRepository
    ) = DeleteFavoriteUserUseCase(githubRepository)
}