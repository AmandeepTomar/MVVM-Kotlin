package com.example.mvvmsample.view.loginview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.base.BaseResponse
import com.example.mvvmsample.utills.AppConstant
import com.example.mvvmsample.utills.Validatror
import com.example.mvvmsample.view.loginview.model.LoginModel

/** view model share by both fragments login and forget
 * or you can design separate view model for both
 * */
class LoginViewModel:ViewModel(){
    // here we write the business login
    // connect to model to get the data
    // provide the data to view
    private var liveData=MutableLiveData<BaseResponse<LoginModel,String>>()


    fun hitLoginApi(userId:String,password:String):MutableLiveData<BaseResponse<LoginModel,String>>{
        val result=Validatror.validateUserId(userId,password)
        var res=BaseResponse<LoginModel,String>()
        if(AppConstant.VALIDATE == result){
            // hit api
            res.m=null
            res.d=LoginModel("email","password")
        }else{
            // return error
            res.m=result
            res.d=null

        }
        liveData.apply {
            value=res
        }
        return liveData
    }

}