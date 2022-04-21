package com.github.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.core.data.local.room.dao.GithubDao
import com.github.core.data.local.room.model.FavoriteUserEntity

@Database(
    entities = [FavoriteUserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun favoriteUsersDao(): GithubDao
}
