package com.example.mvvmsample.view.loginview.model

import com.example.mvvmsample.base.BaseDataModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginModel(
    var total_count: Int = 0

) : BaseDataModel()