package com.example.mvvm_livedata.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class SnackbarMessage : SingleLiveEvent<Int>() {
    fun observe(owner: LifecycleOwner, observer: (Int) -> Unit) {
        super.observe(owner, Observer {
            it.run {
                observer(it)
            }
        })
    }
}

class SnackBarMessageString : SingleLiveEvent<String>(){
    fun observe(owner: LifecycleOwner, observer: (String) -> Unit) {
        super.observe(owner, Observer {
            it.run {
                observer(it)
            }
        })
    }
}