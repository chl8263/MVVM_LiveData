package com.example.mvvm_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvm_livedata.core.BaseActivity
import com.example.mvvm_livedata.viewmodel.MainViewModel
import com.example.mvvm_livedata.databinding.ActivityMainBinding
import com.example.mvvm_livedata.di.modelPart
import com.example.mvvm_livedata.di.viewModelPart
import com.example.mvvm_livedata.model.DataModelImpl
import com.example.mvvm_livedata.model.dto.RepoDTO
import com.example.mvvm_livedata.model.service.GithubService
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by inject()


    override fun initStartView() {

        viewModel.getGithubData("chl8263")
        /*val service : GithubService = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com")
            .build()
            .create(GithubService::class.java)*/

        /*service.listRepos("chl8263")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("aa", it.toString())
            },{
                Log.e("aa", "ㅜㅜ")
            })*/


    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }
}
