package com.github.core.data.remote.api

import com.github.core.data.remote.api.model.userDetail.UserDetailResponse
import com.github.core.data.remote.api.model.userSearch.UserSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubAPI {

    @GET("search/users")
    suspend fun userSearch(
        @Query("q") query: String?
    ): UserSearchResponse?

    @GET("users/{userName}")
    suspend fun userDetail(
        @Path("userName") userName: String?
    ): UserDetailResponse?
}
