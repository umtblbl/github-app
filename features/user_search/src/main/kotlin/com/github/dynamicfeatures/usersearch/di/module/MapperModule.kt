package com.github.dynamicfeatures.usersearch.di.module

import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.usersearch.mapper.AddSearchUserMapper
import com.github.dynamicfeatures.usersearch.mapper.GetAllSearchUserMapper
import com.github.dynamicfeatures.usersearch.mapper.UserSearchMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @FeatureScope
    @Provides
    fun providesUserSearchMapper() = UserSearchMapper()

    @FeatureScope
    @Provides
    fun providesGetAllSearchUserMapper() = GetAllSearchUserMapper()

    @FeatureScope
    @Provides
    fun providesAddSearchUserMapper() = AddSearchUserMapper()
}
