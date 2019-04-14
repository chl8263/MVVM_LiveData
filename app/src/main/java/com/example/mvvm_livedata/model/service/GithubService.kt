package com.example.mvvm_livedata.model.service

import com.example.mvvm_livedata.model.dto.RepoDTO
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{user}/repos")
    fun listRepos(

        @Path("user") user:String

    ) : Single<List<RepoDTO>>
}