package com.example.mvvmsample.view.dashboardview.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmsample.R
import com.example.mvvmsample.base.Resource
import com.example.mvvmsample.callback.OnItemCalanderListView
import com.example.mvvmsample.view.dashboardview.adapters.DashRecyclerAdpater
import com.example.mvvmsample.view.dashboardview.model.DashboardModel
import com.example.mvvmsample.view.dashboardview.model.Items
import com.example.mvvmsample.view.dashboardview.viewModel.DashboardViewModel
import com.findmyfans.util.extension.replaceFragmentWithBack
import com.marutidrivingschool.utility.extensions.showToast
import kotlinx.android.synthetic.main.fragment_dash_board.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DashBoardFragment : Fragment(),OnItemCalanderListView {



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"
    private var viewmodel: DashboardViewModel? = null
    private var mAdpater:DashRecyclerAdpater?=null

    override fun onItemcalanderListViewClick(position: Int, item: Items) {
        showToast("${position}")
        val fragment=UserDetailsFragment.newInstance(item.url,"")
        activity?.supportFragmentManager?.replaceFragmentWithBack(R.id.dashboardContainer,fragment,"UserDetails")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
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
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hitAdiTogeDashboardData()


    }

    fun hitAdiTogeDashboardData() {
        viewmodel!!.getListData(true).observe(this, Observer {
            when (it.status) {
                Resource.LOADING -> {
                    rvDashBoard.visibility = View.GONE
                    dashBoardProgress.visibility = View.VISIBLE
                }
                Resource.SUCCESS -> {
                    rvDashBoard.visibility = View.VISIBLE
                    dashBoardProgress.visibility = View.GONE
                    var data=it.data as DashboardModel
                    data?.let {
                        setRecyclerViewAdapter(data.items)
                    }
                }
                Resource.ERROR -> {
                    rvDashBoard.visibility = View.VISIBLE
                    dashBoardProgress.visibility = View.GONE
                    showToast("${it.message}")
                }
            }
        })
    }

    fun setRecyclerViewAdapter(items: MutableList<Items>) {
        rvDashBoard.layoutManager=LinearLayoutManager(activity)
        mAdpater= DashRecyclerAdpater(this@DashBoardFragment)
        mAdpater?.addListData(items)
        rvDashBoard.adapter=mAdpater
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashBoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
