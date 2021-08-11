package com.oshan.onesmartinterviewassignment.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.oshan.onesmartinterviewassignment.models.DashboardModel

class AddedDashboardsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val dashboardList = ArrayList<DashboardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class DashboardViewHolder(viewBinding: ViewBinding): RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return dashboardList.size + 1
    }
}