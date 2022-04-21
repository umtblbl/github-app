package com.github.core.data.remote.api.dataSource

import com.github.core.data.remote.api.GithubAPI
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val githubAPI: GithubAPI
) {
    suspend fun userSearch(query: String?) = githubAPI.userSearch(query)
    suspend fun userDetail(userName: String?) = githubAPI.userDetail(userName)
}
