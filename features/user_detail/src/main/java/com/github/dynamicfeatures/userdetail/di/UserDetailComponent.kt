package com.github.dynamicfeatures.userdetail.di

import com.github.core.di.CoreComponent
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userdetail.di.module.MapperModule
import com.github.dynamicfeatures.userdetail.di.module.UseCaseModule
import com.github.dynamicfeatures.userdetail.di.module.UserDetailModule
import com.github.dynamicfeatures.userdetail.ui.UserDetailFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        UserDetailModule::class,
        UseCaseModule::class,
        MapperModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface UserDetailComponent {
    fun inject(userDetailFragment: UserDetailFragment)
}
