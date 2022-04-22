package com.github.dynamicfeatures.usersearch.mapper

import com.github.core.data.local.room.model.UserSearchEntity
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel

class AddSearchUserMapper : Mapper<List<ItemUserModel>?, List<UserSearchEntity>> {

    override fun map(from: List<ItemUserModel>?): List<UserSearchEntity> {
        return from?.map { searchUser ->
            UserSearchEntity(
                userName = searchUser.userName ?: return listOf(),
                avatarUrl = searchUser.avatarUrl ?: return listOf(),
                isFavorite = searchUser.isFavorite
            )
        } ?: listOf()
    }
}
