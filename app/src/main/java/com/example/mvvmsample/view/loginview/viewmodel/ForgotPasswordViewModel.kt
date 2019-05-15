package com.example.mvvmsample.view.loginview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmsample.utills.CommonUtills
import com.example.mvvmsample.utills.MyApplication

class ForgotPasswordViewModel(var application: MyApplication) : AndroidViewModel(application) {

    init {
        CommonUtills.setLog(application.packageName + " received")
    }


}