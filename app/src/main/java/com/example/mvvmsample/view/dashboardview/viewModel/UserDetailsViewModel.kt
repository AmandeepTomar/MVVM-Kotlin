package com.example.mvvmsample.view.dashboardview.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.view.dashboardview.model.DashboardDataRepository
import com.marutidrivingschool.baseclasses.awaitResult
import com.marutidrivingschool.baseclasses.getOrThrow
import kotlinx.coroutines.*
import java.lang.Exception

class UserDetailsViewModel : ViewModel() {

    private var userJob:Job?=null

    fun hitApiTogetTheUserDetails(userName:String,isConnected:Boolean):MutableLiveData<Resource<Any>>{
        userJob= Job()
        var result : MutableLiveData<Resource<Any>> = MutableLiveData()
        result.setValue(Resource.loading(null))
        userJob=GlobalScope.launch(Dispatchers.Main+userJob!!) {
            try {
                if (isConnected){
                    val response=DashboardDataRepository().getUserDetailsAsync(userName).awaitResult().getOrThrow()
                    withContext(Dispatchers.Main){
                        result.value=Resource.success(response)
                    }
                }else result.value=Resource.error("Please check your internet connection",0)

            }catch (e:Exception) {
                result.value = Resource.error(e.message, 0)

            }
        }
        return result


    }

}