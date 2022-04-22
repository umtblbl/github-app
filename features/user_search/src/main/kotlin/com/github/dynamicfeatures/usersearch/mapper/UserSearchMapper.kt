package com.github.dynamicfeatures.usersearch.mapper

import com.github.core.data.local.room.model.FavoriteUserEntity
import com.github.core.data.remote.api.model.userSearch.UserSearchResponse
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.usersearch.ui.model.ItemUserModel

data class UserSearchMapperInput(
    val userSearchResponse: UserSearchResponse?,
    val favoriteUsers: List<FavoriteUserEntity>
)

class UserSearchMapper : Mapper<UserSearchMapperInput?, List<ItemUserModel>> {
    override fun map(from: UserSearchMapperInput?): List<ItemUserModel> {
        return from?.userSearchResponse?.users?.map { searchUser ->
            ItemUserModel(
                userName = searchUser?.login,
                avatarUrl = searchUser?.avatarUrl,
                isFavorite = from.favoriteUsers
                    .firstOrNull {
                        it.userName == searchUser?.login
                    } != null
            )
        } ?: listOf()
    }
}
