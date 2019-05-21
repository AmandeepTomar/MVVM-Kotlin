package com.example.mvvmsample.base

import com.example.mvvmsample.retrofit.ApiClient
import com.example.mvvmsample.utills.AppSharedPreference

open class BaseDataRepository {
    var apiClient = ApiClient
    var sharedPreference = AppSharedPreference
}