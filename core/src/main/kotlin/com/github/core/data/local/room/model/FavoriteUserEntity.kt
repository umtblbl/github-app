package com.github.core.data.local.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_users")
data class FavoriteUserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "userName") val userName: String = "",
    @ColumnInfo(name = "avatarUrl") val avatarUrl: String = "",
)
