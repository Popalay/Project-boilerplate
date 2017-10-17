package com.popalay.appname

import com.popalay.appname.injection.DaggerAppComponent
import com.popalay.appname.injection.applyAutoInjector
import com.squareup.leakcanary.LeakCanary
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) return

        applyAutoInjector()
        LeakCanary.install(this)
    }

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()
}