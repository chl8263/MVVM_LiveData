package com.example.mvvm_livedata.di

import com.example.mvvm_livedata.adapter.MainRecyclerViewAdapter
import com.example.mvvm_livedata.model.DataModel
import com.example.mvvm_livedata.model.DataModelImpl
import com.example.mvvm_livedata.model.service.GithubService
import com.example.mvvm_livedata.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


var retrofitPart = module {
    single<GithubService> {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com")
            .build()
            .create(GithubService::class.java)
    }

}

var adapterPart = module {
    factory {
        MainRecyclerViewAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}


var myDiModule = listOf(modelPart, viewModelPart, retrofitPart, adapterPart)