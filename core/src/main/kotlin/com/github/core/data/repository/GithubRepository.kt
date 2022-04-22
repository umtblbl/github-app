package com.github.core.data.repository

import androidx.annotation.VisibleForTesting
import com.github.core.data.local.room.dataSource.GithubLocalDataSource
import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.local.room.model.UserSearchEntity
import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import javax.inject.Inject

class GithubRepository @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val githubRemoteDataSource: GithubRemoteDataSource,
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal val githubLocalDataSource: GithubLocalDataSource
) {
    suspend fun userSearch(query: String?) =
        githubRemoteDataSource.userSearch(query)

    suspend fun userDetail(userName: String?) =
        githubRemoteDataSource.userDetail(userName)

    fun getAllFavoriteUser() =
        githubLocalDataSource.getAllFavoriteUser()

    fun getAllSearchUser() =
        githubLocalDataSource.getAllSearchUser()

    /**
     * Returned value greater than 0 is a successful result
     * because a single data was deleted.
     */
    fun deleteFavoriteUser(userName: String?) =
        githubLocalDataSource.deleteFavoriteUser(userName) > 0

    /**
     * If the number of data added is equal to the number returned,
     * it has been added successfully.
     */
    fun addFavoriteUser(users: List<FavoriteUserEntity>): Boolean {
        deleteAllSearchUser()
        return githubLocalDataSource.addFavoriteUser(users)
            .size == users.size
    }

    /**
     * If the number of data added is equal to the number returned,
     * it has been added successfully.
     */
    fun addSearchUser(users: List<UserSearchEntity>) =
        githubLocalDataSource.addSearchUser(users)
            .size == users.size

    private fun deleteAllSearchUser() =
        githubLocalDataSource.deleteAllSearchUser()
}
