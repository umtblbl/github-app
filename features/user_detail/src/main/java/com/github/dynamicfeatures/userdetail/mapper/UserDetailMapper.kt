package com.github.dynamicfeatures.userdetail.mapper

import com.github.core.data.remote.api.model.userDetail.UserDetailResponse
import com.github.core.mapper.Mapper
import com.github.dynamicfeatures.userdetail.ui.model.ItemUserDetail

class UserDetailMapper : Mapper<UserDetailResponse?, ItemUserDetail> {
    override fun map(from: UserDetailResponse?): ItemUserDetail {
        return ItemUserDetail(
            userName = from?.login,
            avatarUrl = from?.avatarUrl,
            name = from?.name,
            bio = from?.bio,
            followers = from?.followers,
            following = from?.following,
            publicRepos = from?.publicRepos,
            publicGists = from?.publicGists
        )
    }
}
