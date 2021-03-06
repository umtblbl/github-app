package com.github.core.di.module

import com.github.core.data.local.room.dao.FavoriteUserDao
import com.github.core.data.local.room.dao.UserSearchDao
import com.github.core.data.local.room.dataSource.GithubLocalDataSource
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

    @Singleton
    @Provides
    fun provideGithubLocalDataSource(
        favoriteUserDao: FavoriteUserDao,
        userSearchDao: UserSearchDao
    ) = GithubLocalDataSource(favoriteUserDao, userSearchDao)
}
