package com.github.core.di.module

import com.github.core.data.local.room.dataSource.GithubLocalDataSource
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import com.github.core.data.repository.GithubRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGithubRepository(
        githubRemoteDataSource: GithubRemoteDataSource,
        githubLocalDataSource: GithubLocalDataSource
    ) = GithubRepository(
        githubRemoteDataSource,
        githubLocalDataSource
    )
}
