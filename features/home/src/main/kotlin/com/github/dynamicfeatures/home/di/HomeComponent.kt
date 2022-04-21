package com.github.dynamicfeatures.home.di

import com.github.core.di.CoreComponent
import com.github.core.di.scope.FeatureScope
import com.github.dynamicfeatures.home.di.module.ViewModelModule
import com.github.dynamicfeatures.home.ui.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}
