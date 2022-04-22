package com.github.dynamicfeatures.userfavorites.mapper

import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.userfavorites.ui.model.ItemUserModel

class GetAllFavoriteUserMapper : Mapper<List<FavoriteUserEntity>?, List<ItemUserModel>> {
    override fun map(from: List<FavoriteUserEntity>?): List<ItemUserModel> {
        return from?.map { searchUser ->
            ItemUserModel(
                userName = searchUser.userName,
                avatarUrl = searchUser.avatarUrl,
                isFavorite = true
            )
        } ?: listOf()
    }
}
