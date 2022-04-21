package com.github.dynamicfeatures.usersearch.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.commons.di.ViewModelFactory
import com.github.commons.di.ViewModelKey
import com.github.dynamicfeatures.usersearch.ui.UserSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserSearchModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(UserSearchViewModel::class)
    abstract fun provideUserSearchViewModel(userSearchViewModel: UserSearchViewModel): ViewModel
}
