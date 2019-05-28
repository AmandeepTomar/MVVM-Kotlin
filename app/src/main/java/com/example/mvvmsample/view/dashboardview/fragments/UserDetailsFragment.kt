package com.example.mvvmsample.view.dashboardview.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import com.example.mvvmsample.R
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.utills.CommonUtills
import com.example.mvvmsample.view.dashboardview.model.UserDetailsModel
import com.example.mvvmsample.view.dashboardview.viewModel.UserDetailsViewModel
import kotlinx.android.synthetic.main.fragment_user_details.*
import kotlinx.android.synthetic.main.fragment_user_details.view.*
import kotlinx.android.synthetic.main.row_recycler_dash_schedule.view.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UserDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private  val ARG_PARAM1 = "param1"
    private  val ARG_PARAM2 = "param2"
    private var viewModel:UserDetailsViewModel?=null
    private var userNAmeDetails=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(UserDetailsViewModel::class.java)
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
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hitApiToGetDetails(param1!!)
    }


    fun hitApiToGetDetails(userName:String){
        try {
            viewModel?.hitApiTogetTheUserDetails(userName, true)?.observe(this, Observer {
                when (it.status) {
                    Resource.LOADING -> {

                    }
                    Resource.SUCCESS -> {
                        val data=it.data as UserDetailsModel
                        data?.let {
                            setUpView(it)
                        }
                    }
                    Resource.ERROR -> {

                    }
                }

            })
        }catch (e:Exception){
            CommonUtills.setLog(e.toString())
        }
    }

    fun setUpView(it: UserDetailsModel) {
     //   Glide.with(imgBg).load(it.avatar_url).into(imgBg)
        Glide.with(imgUserUserDetails).load(it.avatar_url).into(imgUserUserDetails)
        userNAmeDetails=it.name
        userName.text=it.name
        userCompany.text=it.company
        userBlog.text=it.blog
        userEmail.text="Email : ${it.email}"
        userBio.text="Bio : ${it.bio}"
        userPublicRepo.text="Public Repo ${it.public_repos}"
        userGits.text="Public Gits ${it.public_gists}"

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.title="$userNAmeDetails"
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
