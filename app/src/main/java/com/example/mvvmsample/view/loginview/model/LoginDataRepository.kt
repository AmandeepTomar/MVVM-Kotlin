package com.example.mvvmsample.view.loginview.model

import com.example.mvvmsample.base.BaseDataRepository
import kotlinx.coroutines.Deferred
import retrofit2.Response

class LoginDataRepository:BaseDataRepository(){

    fun sendLoginDetailsAsync(query:String):Deferred<Response<LoginModel>>{
        return apiClient.loginApiInterface.getLoginAsync(query)
    }


}