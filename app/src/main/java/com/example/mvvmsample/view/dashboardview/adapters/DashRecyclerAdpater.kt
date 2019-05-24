package com.example.mvvmsample.view.dashboardview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmsample.R
import com.example.mvvmsample.callback.OnItemCalanderListView
import com.example.mvvmsample.view.dashboardview.model.Items
import kotlinx.android.synthetic.main.row_recycler_dash_schedule.view.*


class DashRecyclerAdpater() : RecyclerView.Adapter<DashRecyclerAdpater.DashViewHolder>() {
    lateinit var mClickOnItemListener: OnItemCalanderListView
    private var dataList:MutableList<Items> = mutableListOf()

    constructor(mClickOnItemListener: OnItemCalanderListView) : this() {
        this.mClickOnItemListener = mClickOnItemListener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashViewHolder {
        return DashViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_recycler_dash_schedule,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DashViewHolder, position: Int) {
        val data = dataList[position]
       // CommonUtills.setLog("${data.toString()}")
        holder.itemView.apply {
            tvRowName.text = "User Name : ${data.login}"
            tvRowUserScore.text = "Score ${data.score}"
            Glide.with(imgUser).load(data.avatar_url).into(imgUser)
            setOnClickListener {
                mClickOnItemListener.onItemcalanderListViewClick(position,data)
            }
            rowGitUser.setOnClickListener {
                mClickOnItemListener.onItemcalanderListViewClick(position,data)
            }
        }
    }

    public class DashViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


   public fun addListData(list:MutableList<Items>){
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}