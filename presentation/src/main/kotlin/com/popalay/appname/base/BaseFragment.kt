package com.popalay.appname.base

import android.support.v4.app.Fragment
import com.popalay.appname.injection.Injectable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment(), Injectable {

    protected val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onDestroyView() {
        disposables.clear()
        super.onDestroyView()
    }
}
