package com.example.mvvmsample.view.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmsample.R
import com.example.mvvmsample.utills.AppSharedPreference
import com.example.mvvmsample.utills.CommonUtills
import com.example.mvvmsample.view.dashboardview.DashboardActivity
import com.example.mvvmsample.view.loginview.LoginActivity
import com.findmyfans.util.extension.start
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var isUserLogin = AppSharedPreference.getUserIsLogin(context = this)

        CommonUtills.setLog("${isUserLogin}")

        GlobalScope.launch {
            delay(2000)
            if (isUserLogin) {
                start(DashboardActivity::class.java)
                finish()
            } else {
                start(LoginActivity::class.java)
                finish()

            }
        }
    }
}
