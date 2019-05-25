package com.example.mvvmsample.view.dashboardview.apiinterface

import com.example.mvvmsample.view.dashboardview.model.DashboardModel
import com.example.mvvmsample.view.dashboardview.model.UserDetailsModel
import com.example.mvvmsample.view.loginview.model.LoginModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DashboardApiInterface {
    @GET("/search/users")
    fun getHomeDataAsync(@Query("q") query: String): Deferred<Response<DashboardModel>>

    @GET
    fun getUserDetailsAsync(@Url url:String):Deferred<Response<UserDetailsModel>>
}