package com.example.mvvmsample.view.loginview.apiinterface

import com.example.mvvmsample.view.loginview.model.LoginModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApiInterface {
    @GET("search/repositories")
    fun getAsyncLogin(@Query("q") query: String): Deferred<Response<LoginModel>>


}