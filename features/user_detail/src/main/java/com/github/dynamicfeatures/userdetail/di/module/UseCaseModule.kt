package com.github.dynamicfeatures.userdetail.di.module

import com.github.core.data.repository.GithubRepository
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userdetail.domain.AddFavoriteUserUseCase
import com.github.dynamicfeatures.userdetail.domain.DeleteFavoriteUserUseCase
import com.github.dynamicfeatures.userdetail.domain.UserDetailUseCase
import com.github.dynamicfeatures.userdetail.mapper.UserDetailMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun provideUserDetailUseCase(
        githubRepository: GithubRepository,
        userDetailMapper: UserDetailMapper
    ) = UserDetailUseCase(githubRepository, userDetailMapper)

    @FeatureScope
    @Provides
    fun provideAddFavoriteUserUseCase(
        githubRepository: GithubRepository
    ) = AddFavoriteUserUseCase(githubRepository)

    @FeatureScope
    @Provides
    fun provideDeleteFavoriteUserUseCase(
        githubRepository: GithubRepository
    ) = DeleteFavoriteUserUseCase(githubRepository)
}
