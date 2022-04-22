package com.github.dynamicfeatures.usersearch.di

import com.github.core.di.CoreComponent
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.usersearch.di.module.MapperModule
import com.github.dynamicfeatures.usersearch.di.module.UseCaseModule
import com.github.dynamicfeatures.usersearch.di.module.UserSearchModule
import com.github.dynamicfeatures.usersearch.ui.UserSearchFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        UserSearchModule::class,
        MapperModule::class,
        UseCaseModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface UserSearchComponent {
    fun inject(userSearchFragment: UserSearchFragment)
}
