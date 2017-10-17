package com.popalay.appname.utils.extensions

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.popalay.appname.base.BaseViewModel


fun FragmentActivity.currentFragment() = supportFragmentManager.fragments?.filter { it.isVisible }?.firstOrNull()

inline fun <reified T : Fragment> AppCompatActivity.findFragmentByType() = supportFragmentManager.fragments
        ?.filter { it is T }
        ?.map { it as T }
        ?.firstOrNull()

inline fun <reified T : BaseViewModel> FragmentActivity.getViewModel(
        factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(application)
): T = ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T : BaseViewModel> Fragment.getViewModel(
        factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(activity.application)
): T = ViewModelProviders.of(this, factory).get(T::class.java)