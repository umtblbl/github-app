package com.github.dynamicfeatures.usersearch.mapper

import com.github.core.data.remote.api.model.userSearch.UserSearchResponse
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel

class UserSearchMapper : Mapper<UserSearchResponse?, List<ItemUserModel>> {
    override suspend fun map(from: UserSearchResponse?): List<ItemUserModel> {
        return from?.users?.map {
            ItemUserModel(
                userName = it?.login,
                avatarUrl = it?.avatarUrl
            )
        } ?: listOf()
    }
}
