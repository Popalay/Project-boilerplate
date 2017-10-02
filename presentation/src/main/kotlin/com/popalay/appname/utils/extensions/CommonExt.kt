package com.popalay.appname.utils.extensions

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.popalay.appname.presentation.base.BaseViewModel


fun FragmentActivity.currentFragment() = supportFragmentManager.fragments?.filter { it.isVisible }?.firstOrNull()

inline fun <reified T : Fragment> AppCompatActivity.findFragmentByType() = supportFragmentManager.fragments
        ?.filter { it is T }
        ?.map { it as T }
        ?.firstOrNull()

fun <T : ViewDataBinding> FragmentActivity.getDataBinding(@LayoutRes layoutId: Int
): T = DataBindingUtil.setContentView(this, layoutId)

fun <T : ViewDataBinding> Fragment.getDataBinding(
        inflater: LayoutInflater?,
        @LayoutRes layoutId: Int,
        container: ViewGroup?
): T = DataBindingUtil.inflate(inflater, layoutId, container, false)

inline fun <reified T : BaseViewModel> FragmentActivity.getViewModel(
        factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(application)
): T = ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T : BaseViewModel> Fragment.getViewModel(
        factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(activity.application)
): T = ViewModelProviders.of(this, factory).get(T::class.java)