package com.github.core.data.local.room.dataSource

import com.github.core.data.local.room.dao.FavoriteUserDao
import com.github.core.data.local.room.dao.UserSearchDao
import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.local.room.model.UserSearchEntity
import javax.inject.Inject

class GithubLocalDataSource @Inject constructor(
    private val favoriteUserDao: FavoriteUserDao,
    private val userSearchDao: UserSearchDao
) {
    fun addFavoriteUser(users: List<FavoriteUserEntity>) =
        favoriteUserDao.add(*users.toTypedArray())

    fun searchFavoriteUser(userName: String): List<FavoriteUserEntity> =
        favoriteUserDao.search("%$userName%")

    fun deleteFavoriteUser(userName: String?): Int =
        favoriteUserDao.delete(userName)

    fun addSearchUser(users: List<UserSearchEntity>) =
        userSearchDao.add(*users.toTypedArray())

    fun getAllFavoriteUser(): List<FavoriteUserEntity> =
        favoriteUserDao.getAll()

    fun getAllSearchUser(): List<UserSearchEntity> =
        userSearchDao.getAll()

    fun deleteAllSearchUser() = userSearchDao.deleteAll()
}
