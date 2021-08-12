package com.oshan.onesmartinterviewassignment.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.oshan.onesmartinterviewassignment.databinding.ItemAddNewDashboardBinding
import com.oshan.onesmartinterviewassignment.databinding.ItemDashboardBinding
import com.oshan.onesmartinterviewassignment.models.DashboardModel
import com.oshan.onesmartinterviewassignment.utils.ScreenUtils

class AddedDashboardsAdapter(val dashboardList: ArrayList<DashboardModel>, val onAddDashboardClickListener: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val viewBinding =
                ItemDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            val view = viewBinding.root
            val params = view.layoutParams
            params.width = ScreenUtils.screenWidth / 4
            params.height = ScreenUtils.dpToPx(100f)
            view.layoutParams = params
            DashboardViewHolder(viewBinding)
        } else {
            val viewBinding =
                ItemAddNewDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            val view = viewBinding.root
            val params = view.layoutParams
            params.width = ScreenUtils.screenWidth / 4
            params.height = ScreenUtils.dpToPx(100f)
            view.layoutParams = params
            AddDashboardViewHolder(viewBinding)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DashboardViewHolder) {
            holder.bind(dashboardList[position])
        } else if (holder is AddDashboardViewHolder) {
            holder.bind()
        }
    }

    inner class DashboardViewHolder(viewBinding: ItemDashboardBinding): RecyclerView.ViewHolder(viewBinding.root) {
        val imageView = viewBinding.imageView

        fun bind(dashboardModel: DashboardModel) {
            imageView.setImageResource(dashboardModel.icon)
        }
    }

    inner class AddDashboardViewHolder(val viewBinding: ItemAddNewDashboardBinding): RecyclerView.ViewHolder(viewBinding.root) {
        val view = viewBinding.root

        fun bind() {
            view.setOnClickListener {
                onAddDashboardClickListener()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < dashboardList.size) 0 else 1
    }

    override fun getItemCount(): Int {
        return dashboardList.size + 1
    }
}