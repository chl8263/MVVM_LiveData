package com.example.mvvm_livedata.utils

import android.nfc.Tag
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

open class SingleLiveEvent<T> : MutableLiveData<T>(){

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if(hasActiveObservers()) Log.w("multifle observing","옵저빙이 여러개입니다. 애는 한번만 동작합니다")

        //super.observe(owner, observer)
        super.observe(owner, Observer { t ->
            if (!mPending.get()) {
                observer.onChanged(t)
                mPending.set(true)
            }
            else return@Observer
            /*if(mPending.compareAndSet(true,false)) {
                observer.onChanged(t)
            }
            else return@Observer*/
        })
    }

    @MainThread
    override fun setValue(value: T) {
        //mPending.set(true)  //atomic boolean 을 true로 바꿔주어 이벤트를 발생시키지 않는다.
        super.setValue(value)
    }

    @MainThread
    fun call(){
        //mPending.set(true)
        Log.e("a",mPending.toString())
        setValue(null as T)
    }
}