package com.github.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.core.Configs
import com.github.core.data.local.room.dao.FavoriteUserDao
import com.github.core.data.local.room.dao.UserSearchDao
import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.local.room.model.UserSearchEntity

@Database(
    entities = [
        FavoriteUserEntity::class,
        UserSearchEntity::class
    ],
    version = Configs.Database.VERSION,
    exportSchema = Configs.Database.EXPORT_SCHEME
)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun favoriteUsersDao(): FavoriteUserDao
    abstract fun userSearchDao(): UserSearchDao
}
