package com.example.mvvmsample.view.loginview.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.mvvmsample.R
import com.example.mvvmsample.view.loginview.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_fragmet.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragmet.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LoginFragmet : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  val ARG_PARAM1 = "param1"
    private  val ARG_PARAM2 = "param2"
    private lateinit var loginViewMode: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewMode=ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
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



    }

    fun handleLoginClick(){
        if(loginViewMode.name.equals("data")){
           /* loginViewMode.name="sent data"
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.loginContainer,ForgotPasswordFragments.newInstance("",""))
                .commit()*/

            loginViewMode.addData()

        }
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragmet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragmet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
