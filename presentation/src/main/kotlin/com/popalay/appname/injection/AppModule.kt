package com.popalay.appname.injection

import android.content.Context
import com.popalay.appname.App
import com.popalay.cardme.presentation.base.navigation.CustomRouter
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Singleton

@Module
class AppModule {

    private val cicerone = Cicerone.create(CustomRouter())

    @Provides
    @Singleton
    fun provideApplicationContext(app: App): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideRouter(): CustomRouter = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder

}