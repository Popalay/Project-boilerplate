package com.popalay.appname.utils.extensions

import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import java.util.concurrent.TimeUnit

fun <T : Any> Flowable<T>.applyThrottling(): Flowable<T> = compose(applyThrottlingFlowable<T>())

fun <T : Any> Observable<T>.applyThrottling(): Observable<T> = compose(applyThrottlingObservable<T>())

private fun <T : Any> applyThrottlingObservable(): ObservableTransformer<T, T> = ObservableTransformer {
    it.throttleFirst(500L, TimeUnit.MILLISECONDS)
}

private fun <T : Any> applyThrottlingFlowable(): FlowableTransformer<T, T> = FlowableTransformer {
    it.throttleFirst(500L, TimeUnit.MILLISECONDS)
}