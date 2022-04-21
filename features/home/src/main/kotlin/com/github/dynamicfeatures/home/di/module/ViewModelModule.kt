package com.github.dynamicfeatures.home.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import com.github.commons.di.ViewModelKey
import com.github.dynamicfeatures.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}