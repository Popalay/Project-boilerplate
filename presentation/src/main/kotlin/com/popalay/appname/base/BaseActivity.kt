package com.popalay.appname.base

import android.support.v7.app.AppCompatActivity
import com.popalay.appname.injection.Injectable
import com.popalay.appname.presentation.base.navigation.CustomNavigator
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), Injectable {

    @Inject lateinit var navigationHolder: NavigatorHolder

    protected val disposables: CompositeDisposable by lazy { CompositeDisposable() }
    protected open var navigator = CustomNavigator(this)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        disposables.clear()
        super.onDestroy()
    }
}
