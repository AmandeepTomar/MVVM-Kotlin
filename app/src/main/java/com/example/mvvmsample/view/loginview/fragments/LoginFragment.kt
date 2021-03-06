package com.example.mvvmsample.view.loginview.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.mvvmsample.R
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.utills.AppSharedPreference
import com.example.mvvmsample.utills.CommonUtills
import com.example.mvvmsample.view.dashboardview.DashboardActivity
import com.example.mvvmsample.view.loginview.model.LoginModel
import com.example.mvvmsample.view.loginview.viewmodel.LoginViewModel
import com.example.mvvmsample.utills.extensions.startWithFinish
import com.example.mvvmsample.utills.extensions.showToast
import kotlinx.android.synthetic.main.login_fragmet.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  val ARG_PARAM1 = "param1"
    private  val ARG_PARAM2 = "param2"
    private lateinit var loginViewMode: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewMode=ViewModelProviders.of(this).get(LoginViewModel::class.java)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login_fragmet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleLoginClick()

    }

   private fun handleLoginClick(){
       btnLogin.setOnClickListener {
           try {
               loginViewMode.hitLoginApi(etUserId.text.toString(),etPassword.text.toString()).observe(this, Observer {
                   CommonUtills.setLog("${it.status} new data ${it.data.toString()}")
                   when (it.status) {
                       Resource.LOADING -> {
                           btnLogin.visibility=View.INVISIBLE
                           progressBarLogin.visibility=View.VISIBLE
                       }
                       Resource.SUCCESS -> {
                           val response = it.data as LoginModel
                           btnLogin.visibility=View.VISIBLE
                           progressBarLogin.visibility=View.INVISIBLE
                           response.let {
                               CommonUtills.setLog(it.toString())
                               showToast("User logged-in successfully")
                               AppSharedPreference.setUserIsLogin(context!!,true)
                               activity?.let {
                                   startWithFinish(DashboardActivity::class.java)
                               }
                           }
                       }
                       Resource.ERROR -> {
                           btnLogin.visibility=View.VISIBLE
                           progressBarLogin.visibility=View.INVISIBLE
                           showToast(it.message.toString())
                       }
                   }
               })
           }catch (e:Exception){
               CommonUtills.setLog(e.toString())
           }
       }

    }





    override fun onStop() {
        super.onStop()
        calledOnStopReleaseAllResourse()
    }


    fun calledOnStopReleaseAllResourse() {
        var isActive = loginViewMode?.job?.isActive
        if (isActive != null && isActive) {
            CommonUtills.setLog("{loginViewMode?.job?.isActive}")
            loginViewMode?.job?.cancel()

        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
