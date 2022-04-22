package com.github.dynamicfeatures.usersearch.di.module

import com.github.core.data.repository.GithubRepository
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.usersearch.domain.*
import com.github.dynamicfeatures.usersearch.mapper.AddSearchUserMapper
import com.github.dynamicfeatures.usersearch.mapper.GetAllSearchUserMapper
import com.github.dynamicfeatures.usersearch.mapper.UserSearchMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun provideUserSearchUseCase(
        githubRepository: GithubRepository,
        userSearchMapper: UserSearchMapper
    ) = UserSearchUseCase(githubRepository, userSearchMapper)

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

    @FeatureScope
    @Provides
    fun provideAddSearchUserUseCase(
        githubRepository: GithubRepository,
        addSearchUserMapper: AddSearchUserMapper
    ) = AddSearchUserUseCase(githubRepository, addSearchUserMapper)

    @FeatureScope
    @Provides
    fun provideGetAllSearchUserUseCase(
        githubRepository: GithubRepository,
        getAllSearchUserMapper: GetAllSearchUserMapper
    ) = GetAllSearchUserUseCase(githubRepository, getAllSearchUserMapper)
}
