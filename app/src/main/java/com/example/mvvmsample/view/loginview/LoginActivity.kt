package com.example.mvvmsample.view.loginview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmsample.R
import com.example.mvvmsample.view.loginview.fragments.LoginFragment
import com.example.mvvmsample.view.loginview.viewmodel.LoginViewModel
import com.example.mvvmsample.utills.extensions.replaceFragment

class LoginActivity : AppCompatActivity() {
    private var viewModel:LoginViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  viewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val fragment=LoginFragment.newInstance("","")
        supportFragmentManager.replaceFragment(R.id.loginContainer,fragment,"Login")

    }
}
