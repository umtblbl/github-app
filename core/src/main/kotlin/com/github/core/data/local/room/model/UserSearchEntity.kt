package com.github.core.data.local.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_search")
data class UserSearchEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "userName") val userName: String = "",
    @ColumnInfo(name = "avatarUrl") val avatarUrl: String = "",
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false,
)
