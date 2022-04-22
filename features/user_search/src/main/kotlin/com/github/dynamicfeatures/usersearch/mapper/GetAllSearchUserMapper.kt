package com.github.dynamicfeatures.usersearch.mapper

import com.github.core.data.local.room.model.UserSearchEntity
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel

class GetAllSearchUserMapper : Mapper<List<UserSearchEntity>?, List<ItemUserModel>> {
    override fun map(from: List<UserSearchEntity>?): List<ItemUserModel> {
        return from?.map { searchUser ->
            ItemUserModel(
                userName = searchUser.userName,
                avatarUrl = searchUser.avatarUrl,
                isFavorite = searchUser.isFavorite
            )
        } ?: listOf()
    }
}
