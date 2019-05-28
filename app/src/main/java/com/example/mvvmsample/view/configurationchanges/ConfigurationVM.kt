package com.example.mvvmsample.view.configurationchanges

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfigurationVM : ViewModel() {

    var updateData: MutableLiveData<String> = MutableLiveData()
    var score: Int = 0


    fun getUpdatedData(): MutableLiveData<String> {
        return updateData.apply {
            score++
            value = score.toString()
        }
    }
}