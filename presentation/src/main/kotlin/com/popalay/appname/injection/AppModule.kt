package com.popalay.appname.injection

import android.content.Context
import com.popalay.appname.App
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class AppModule {

    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun provideApplicationContext(app: App): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder

}