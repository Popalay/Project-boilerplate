package com.popalay.appname

import com.facebook.stetho.Stetho
import com.popalay.appname.injection.AppComponent
import com.popalay.appname.injection.applyAutoInjector
import com.popalay.cardme.injection.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.support.DaggerApplication
import shortbread.Shortbread

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) return
        app = this

        applyAutoInjector()
        LeakCanary.install(this)

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build())
    }

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build().apply { appComponent = this }

    companion object {

        lateinit var app: App
        @JvmStatic lateinit var appComponent: AppComponent

    }
}