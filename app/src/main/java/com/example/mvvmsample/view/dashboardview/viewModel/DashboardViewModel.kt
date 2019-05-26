package com.example.mvvmsample.view.dashboardview.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.view.dashboardview.model.DashboardDataRepository
import com.marutidrivingschool.baseclasses.awaitResult
import com.marutidrivingschool.baseclasses.getOrThrow
import kotlinx.coroutines.*
import java.lang.Exception

class DashboardViewModel : ViewModel() {
    var listJob: Job? = null

    /**
     * This is network call to fetch the data of users
     * @return MutableLiveData<Resource<Any>>*/
    fun getListData(isConnected: Boolean): MutableLiveData<Resource<Any>> {
        listJob = Job()
        var result: MutableLiveData<Resource<Any>> = MutableLiveData()
        result.setValue(Resource.loading(null))
        listJob = GlobalScope.launch(Dispatchers.IO + listJob!!) {
            try {
                if (isConnected) {
                    val response = DashboardDataRepository().getListDataAsync("aman").awaitResult().getOrThrow()
                    withContext(Dispatchers.Main) {
                        result.value = Resource.success(response)
                    }
                } else result.value = Resource.error("Please check your internet", 0)
            } catch (e: Exception) { result.value = Resource.error(e.message, 0) }
        }
        return result
    }
}