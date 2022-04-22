package com.github.dynamicfeatures.userdetail.di.module

import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userdetail.mapper.UserDetailMapper
import dagger.Module
import dagger.Provides


@Module
class MapperModule {

    @FeatureScope
    @Provides
    fun provideUserDetailMapper() = UserDetailMapper()
}
