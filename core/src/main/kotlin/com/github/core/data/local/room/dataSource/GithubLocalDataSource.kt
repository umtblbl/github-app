package com.github.core.data.local.room.dataSource

import com.github.core.data.local.room.dao.GithubDao
import com.github.core.data.local.room.model.FavoriteUserEntity
import javax.inject.Inject

class GithubLocalDataSource @Inject constructor(
    private val githubDao: GithubDao
) {
    suspend fun addFavoriteUser(users: List<FavoriteUserEntity>) =
        githubDao.add(*users.toTypedArray())

    suspend fun searchFavoriteUser(userName: String?): List<FavoriteUserEntity> =
        githubDao.search("%$userName%")

    suspend fun getAllFavoriteUser(): List<FavoriteUserEntity> =
        githubDao.getAll()
}
