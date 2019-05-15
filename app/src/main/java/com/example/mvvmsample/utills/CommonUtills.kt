package com.example.mvvmsample.utills

import android.os.Build
import android.util.Log
import com.example.mvvmsample.BuildConfig

object CommonUtills {

    public fun setLog(message: String) {
        if (BuildConfig.DEBUG)
            Log.e("tag", message)
    }
}