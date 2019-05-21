package com.example.mvvmsample.utills

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object AppSharedPreference {
    private val PREF_USER_LOGIN = "PrefUserIsLogin"

    fun setUserIsLogin(context: Context, isUserLogin: Boolean) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        sharedPreferences.edit().putBoolean(PREF_USER_LOGIN, isUserLogin).apply()
    }

    fun getUserIsLogin(context: Context):Boolean?{
        var sharedPrefernce: SharedPreferences =PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPrefernce.getBoolean(PREF_USER_LOGIN,false)
    }
}