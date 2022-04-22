package com.github.dynamicfeatures.userdetail.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import com.github.commons.di.ViewModelKey
import com.github.dynamicfeatures.userdetail.ui.UserDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserDetailModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun provideUserDetailViewModel(userFavoritesViewModel: UserDetailViewModel): ViewModel
}
