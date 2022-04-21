package com.github.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.core.data.local.room.model.FavoriteUserEntity

@Dao
interface GithubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg coin: FavoriteUserEntity): LongArray

    @Query("SELECT * FROM favorite_users WHERE userName LIKE :userName")
    fun search(userName: String?): List<FavoriteUserEntity>

    @Query("SELECT * FROM favorite_users")
    fun getAll(): List<FavoriteUserEntity>
}
