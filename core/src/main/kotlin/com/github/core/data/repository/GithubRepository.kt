package com.github.core.data.repository

import com.github.core.data.local.room.dataSource.GithubLocalDataSource
import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource,
    private val githubLocalDataSource: GithubLocalDataSource
) {
    suspend fun userSearch(query: String?) =
        githubRemoteDataSource.userSearch(query)

    suspend fun userDetail(userName: String?) =
        githubRemoteDataSource.userDetail(userName)

    suspend fun getAllFavoriteUser() =
        githubLocalDataSource.getAllFavoriteUser()

    suspend fun searchFavoriteUser(userName: String) =
        githubLocalDataSource.searchFavoriteUser(userName)

    /**
     * If the number of data added is equal to the number returned,
     * it has been added successfully.
     */
    suspend fun addFavoriteUser(userName: String?, avatarUrl: String?): Boolean {
        val longArray = githubLocalDataSource.addFavoriteUser(
            listOf(
                FavoriteUserEntity(
                    userName = userName ?: return false,
                    avatarUrl = avatarUrl ?: return false
                )
            )
        )
        return longArray.size == 1
    }
}
