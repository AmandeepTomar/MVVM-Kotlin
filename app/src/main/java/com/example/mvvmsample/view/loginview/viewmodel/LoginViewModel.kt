package com.example.mvvmsample.view.loginview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.base.BaseResponse
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.utills.AppConstant
import com.example.mvvmsample.utills.CommonUtills
import com.example.mvvmsample.utills.Validator
import com.example.mvvmsample.view.loginview.model.LoginDataRepository
import com.example.mvvmsample.view.loginview.model.LoginModel
import com.marutidrivingschool.baseclasses.Result
import com.marutidrivingschool.baseclasses.awaitResult
import com.marutidrivingschool.baseclasses.getOrThrow
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.lang.Exception

/** view model share by both fragments login and forget
 * or you can design separate view model for both
 * */
class LoginViewModel : ViewModel() {
    // here we write the business login
    // connect to model to get the data
    // provide the data to view
    var job: Job? = null


    fun hitLoginApi(userId: String, password: String): MutableLiveData<Resource<Any>> {
        var liveData: MutableLiveData<Resource<Any>> = MutableLiveData()
        val result = Validator.validateUserId(userId, password)
        if (AppConstant.VALIDATE == result) {
           return sendLoginDataToView(true)
        } else {
            liveData.value = Resource.error(result, 0)
            return liveData
        }

    }

    fun sendLoginDataToView(isConnected: Boolean): MutableLiveData<Resource<Any>> {
        job = Job()
        var result: MutableLiveData<Resource<Any>> = MutableLiveData()
        result.setValue(Resource.loading(null))
        job = GlobalScope.launch(Dispatchers.Main + job!!) {
            try {
                if (isConnected) {
                    val response = LoginDataRepository().sendLoginDetailsAsync("q").awaitResult().getOrThrow()
                    withContext(Dispatchers.Main) {

                        result.value = Resource.success(response)
                    }
                } else result.value = Resource.error("Please check your internet connection", 0)
            } catch (e: HttpException) {
                CommonUtills.setLog(e.toString())
                result.value = Resource.error(e.message, 0)

            }
        }
        return result
    }

}