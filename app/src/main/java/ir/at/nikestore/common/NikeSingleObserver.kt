package ir.at.nikestore.common

import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus

abstract class NikeSingleObserver<T>(val compositeDisposable: CompositeDisposable) : SingleObserver<T> {
    override fun onSubscribe(d: Disposable) {
        compositeDisposable.add(compositeDisposable)
    }

    override fun onError(e: Throwable) {
        EventBus.getDefault().post(NikeExceptionMapper.map(e))
    }
}