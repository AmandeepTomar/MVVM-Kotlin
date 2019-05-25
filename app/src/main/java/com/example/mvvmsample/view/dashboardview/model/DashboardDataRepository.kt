package com.example.mvvmsample.view.dashboardview.model

import com.example.mvvmsample.base.BaseDataRepository
import com.example.mvvmsample.utills.AppConstant.Companion.BASE_URL
import kotlinx.coroutines.Deferred
import retrofit2.Response

class DashboardDataRepository :BaseDataRepository(){

    fun getListDataAsync(query:String):Deferred<Response<DashboardModel>>{
        return apiClient.dashboardApiInterface.getHomeDataAsync(query)
    }

    fun getUserDetailsAsync(userName:String):Deferred<Response<UserDetailsModel>>{
        return apiClient.dashboardApiInterface.getUserDetailsAsync(userName)
    }
}