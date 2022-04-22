package com.github.dynamicfeatures.userfavorites.di.module

import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userfavorites.mapper.GetAllFavoriteUserMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @FeatureScope
    @Provides
    fun providesGetAllFavoriteUserMapper() = GetAllFavoriteUserMapper()
}
