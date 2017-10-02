package com.popalay.appname.injection

import com.popalay.appname.App
import com.popalay.appname.data.injection.DataModule
import com.popalay.cardme.presentation.base.navigation.CustomRouter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        DaggerViewModelInjectionModule::class,
        UiModule::class,
        DataModule::class,
        AppModule::class)
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun getRouter(): CustomRouter

}