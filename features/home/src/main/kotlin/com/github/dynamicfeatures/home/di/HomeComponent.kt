package com.github.dynamicfeatures.home.di

import com.github.core.di.CoreComponent
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.home.di.module.HomeModule
import com.github.dynamicfeatures.home.ui.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}
