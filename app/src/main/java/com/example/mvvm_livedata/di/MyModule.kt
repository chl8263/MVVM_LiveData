package com.example.mvvm_livedata.di

import com.example.mvvm_livedata.model.DataModel
import com.example.mvvm_livedata.model.DataModelImpl
import com.example.mvvm_livedata.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var modelPart = module {
    factory<DataModel> {
        DataModelImpl()
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}


var myDiModule = listOf(modelPart, viewModelPart)