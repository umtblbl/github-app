package com.github.core.data.remote.api.model.userSearch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserSearchResponse(
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean?,
    @Json(name = "items")
    val searchUsers: List<SearchUser>?,
    @Json(name = "total_count")
    val totalCount: Int?
)
