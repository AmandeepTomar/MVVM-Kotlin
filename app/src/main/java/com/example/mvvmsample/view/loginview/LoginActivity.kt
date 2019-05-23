package com.example.mvvmsample.view.loginview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.R
import com.example.mvvmsample.view.loginview.fragments.LoginFragmet
import com.example.mvvmsample.view.loginview.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private var viewModel:LoginViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  viewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        supportFragmentManager.beginTransaction()
            .replace(R.id.loginContainer,LoginFragmet.newInstance("",""))
            .commit()

    }
}
