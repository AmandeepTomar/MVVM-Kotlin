package com.example.mvvmsample.view.loginview.model

import com.example.mvvmsample.base.BaseDataRepository
import kotlinx.coroutines.Deferred
import retrofit2.Response

class LoginDataRepository:BaseDataRepository(){
    // get login interface
    val apiInterface=apiClient.loginApiInterface


    fun sendLoginDetailsAsync(query:String):Deferred<Response<LoginModel>>{
        return apiClient.loginApiInterface.getAsyncLogin(query)
    }


}