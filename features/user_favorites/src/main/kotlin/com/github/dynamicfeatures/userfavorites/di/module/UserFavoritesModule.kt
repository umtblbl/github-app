package com.github.dynamicfeatures.userfavorites.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import com.github.commons.di.ViewModelKey
import com.github.dynamicfeatures.userfavorites.ui.UserFavoritesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserFavoritesModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(UserFavoritesViewModel::class)
    abstract fun provideUserFavoritesViewModel(userFavoritesViewModel: UserFavoritesViewModel): ViewModel
}
