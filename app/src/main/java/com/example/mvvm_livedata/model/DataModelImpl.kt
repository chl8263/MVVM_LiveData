package com.example.mvvm_livedata.model

import com.example.mvvm_livedata.model.dto.RepoDTO
import com.example.mvvm_livedata.model.service.GithubService
import io.reactivex.Single

class DataModelImpl(private val service: GithubService) : DataModel{
    override fun getData(query : String) : Single<List<RepoDTO>> {
        return service.listRepos(query)
    }
}