package com.github.core.data.repository

import com.github.core.data.remote.api.dataSource.GithubRemoteDataSource
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) {
    suspend fun userSearch(query: String?) = githubRemoteDataSource.userSearch(query)
    suspend fun userDetail(userName: String?) = githubRemoteDataSource.userDetail(userName)
}
