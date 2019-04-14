package com.example.mvvm_livedata.model

import com.example.mvvm_livedata.model.dto.RepoDTO
import io.reactivex.Single

interface DataModel {
    fun getData(query : String): Single<List<RepoDTO>>
}