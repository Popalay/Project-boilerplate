package com.popalay.appname.base

import android.content.Intent
import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.SupportAppNavigator

open class CustomNavigator(
        private val activity: BaseActivity,
        containerId: Int = 0
) : SupportAppNavigator(activity, containerId) {

    override fun createFragment(screenKey: String, data: Any?): Fragment? = null

    override fun createActivityIntent(screenKey: String, data: Any?): Intent? = null
}