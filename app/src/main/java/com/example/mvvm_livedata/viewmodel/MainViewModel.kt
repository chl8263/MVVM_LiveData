package com.example.mvvm_livedata.viewmodel

import android.util.Log
import com.example.mvvm_livedata.core.BaseViewModel
import com.example.mvvm_livedata.model.DataModel
import com.example.mvvm_livedata.model.dto.RepoDTO
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val model:DataModel) : BaseViewModel(){

    fun getGithubData(query: String){

        addDisposable(model.getData(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    if(it.size != 0)
                }
            },{
                Log.e(javaClass.name , "getGuthub repo error")
            })
        )

    }

}