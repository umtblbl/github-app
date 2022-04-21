package com.github.dynamicfeatures.usersearch.di.module

import com.github.core.data.repository.GithubRepository
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.usersearch.domain.AddFavoriteUserUseCase
import com.github.dynamicfeatures.usersearch.domain.UserSearchUseCase
import com.github.dynamicfeatures.usersearch.mapper.UserSearchMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun providesUserSearchMapper() = UserSearchMapper()

    @FeatureScope
    @Provides
    fun provideUserSearchUseCase(
        githubRepository: GithubRepository,
        userSearchMapper: UserSearchMapper
    ) = UserSearchUseCase(
        githubRepository,
        userSearchMapper
    )

    @FeatureScope
    @Provides
    fun provideAddFavoriteUserUseCase(
        githubRepository: GithubRepository
    ) = AddFavoriteUserUseCase(githubRepository)
}
