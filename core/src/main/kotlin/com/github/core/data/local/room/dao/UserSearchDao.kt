package com.github.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.core.data.local.room.model.UserSearchEntity

@Dao
interface UserSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg coin: UserSearchEntity): LongArray

    @Query("SELECT * FROM user_search")
    fun getAll(): List<UserSearchEntity>

    @Query("DELETE FROM user_search")
    fun deleteAll()
}
