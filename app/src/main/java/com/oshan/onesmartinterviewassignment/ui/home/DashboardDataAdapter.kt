package com.oshan.onesmartinterviewassignment.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oshan.onesmartinterviewassignment.R
import com.oshan.onesmartinterviewassignment.databinding.ItemControlDeviceBinding
import com.oshan.onesmartinterviewassignment.models.ControlDevice

class DashboardDataAdapter(val controlDeviceList: ArrayList<ControlDevice>): RecyclerView.Adapter<DashboardDataAdapter.DashboardDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardDataViewHolder {
        val viewBinding = ItemControlDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DashboardDataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DashboardDataViewHolder, position: Int) {
        holder.bind(controlDeviceList[position])
    }

    override fun getItemCount(): Int {
        return controlDeviceList.size
    }

    class DashboardDataViewHolder(val viewBinding: ItemControlDeviceBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(controlDevice: ControlDevice){
            viewBinding.txtDashboardName.text = controlDevice.dashboard
            viewBinding.txtDeviceName.text = controlDevice.name

            if (controlDevice.powerOn) {
                viewBinding.imgPowerOnOff.setImageResource(R.drawable.ic__power_on)
            } else {
                viewBinding.imgPowerOnOff.setImageResource(R.drawable.ic__power)
            }

            if (controlDevice.connected) {

            }
        }
    }


}