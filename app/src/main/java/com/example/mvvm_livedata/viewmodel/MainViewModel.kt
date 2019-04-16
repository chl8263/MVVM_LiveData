package com.example.mvvm_livedata.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_livedata.core.BaseViewModel
import com.example.mvvm_livedata.model.DataModel
import com.example.mvvm_livedata.model.dto.RepoDTO
import com.example.mvvm_livedata.utils.SingleLiveEvent
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model:DataModel) : BaseViewModel(){

    private val _githubLiveData = MutableLiveData<List<RepoDTO>>()

    val githubLiveData : LiveData<List<RepoDTO>>
        get() = _githubLiveData

    fun getGithubData(query: String){

        addDisposable(model.getData(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if(it.size != 0) _githubLiveData.postValue(it)
                }
            },{
                Log.e(javaClass.name , "getGuthub repo error")
            })
        )

    }

    val _startSubActivityEvent = SingleLiveEvent<Any>()
    val startSubActivityEvent : LiveData<Any>
        get() = _startSubActivityEvent

    fun goSubActivity(){
        _startSubActivityEvent.call()
    }

}