package com.popalay.appname.injection

import android.arch.lifecycle.ViewModelProvider
import com.popalay.appname.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class UiModule {

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    //TODO provide activity modules

}