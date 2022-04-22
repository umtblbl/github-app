package com.github.core.di.module

import android.content.Context
import androidx.room.Room
import com.github.core.Configs
import com.github.core.data.local.room.GithubDatabase
import com.github.core.data.local.room.dao.FavoriteUserDao
import com.github.core.data.local.room.dao.UserSearchDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): GithubDatabase =
         Room.databaseBuilder(
            context,
            GithubDatabase::class.java,
            Configs.Database.NAME
        ).fallbackToDestructiveMigration().build()


    @Provides
    fun provideFavoriteUsersDao(githubDatabase: GithubDatabase): FavoriteUserDao =
        githubDatabase.favoriteUsersDao()

    @Provides
    fun provideUserSearchDao(githubDatabase: GithubDatabase): UserSearchDao =
        githubDatabase.userSearchDao()

}
