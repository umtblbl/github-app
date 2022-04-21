package com.github.core.di.module

import com.github.core.data.repository.GithubRepository
import com.github.core.domain.github.UserSearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideUserSearchUserCase(githubRepository: GithubRepository) =
        UserSearchUseCase(githubRepository)
}
