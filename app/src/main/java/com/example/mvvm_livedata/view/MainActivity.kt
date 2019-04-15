package com.example.mvvm_livedata.view

import com.example.mvvm_livedata.R
import com.example.mvvm_livedata.core.BaseActivity
import com.example.mvvm_livedata.viewmodel.MainViewModel
import com.example.mvvm_livedata.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

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
