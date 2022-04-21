package com.github.dynamicfeatures.userfavorites.di

import com.github.core.di.CoreComponent
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.userfavorites.di.module.UserFavoritesModule
import com.github.dynamicfeatures.userfavorites.ui.UserFavoritesFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [UserFavoritesModule::class],
    dependencies = [CoreComponent::class]
)
interface UserFavoritesComponent {
    fun inject(userFavoritesFragment: UserFavoritesFragment)
}
