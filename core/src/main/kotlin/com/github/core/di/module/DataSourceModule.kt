package com.github.core.di.module

import com.github.core.data.remote.api.GithubAPI
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideGithubRemoteDataSource(githubAPI: GithubAPI) =
        GithubRemoteDataSource(githubAPI)
}
