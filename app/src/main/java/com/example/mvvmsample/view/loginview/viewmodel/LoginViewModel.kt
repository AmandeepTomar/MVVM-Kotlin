package com.example.mvvmsample.view.loginview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/** view model share by both fragments login and forget
 * or you can design separate view model for both
 * */
class LoginViewModel:ViewModel(){

    var name:String="data"
    var data=MutableLiveData<String>()



    fun addData():MutableLiveData<String>{
       var num= Math.random()
        data.value=num.toString()

        data.apply {  }

        return data
    }

}