package com.oshan.onesmartinterviewassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oshan.onesmartinterviewassignment.R
import com.oshan.onesmartinterviewassignment.databinding.FragmentDashboardsBinding
import com.oshan.onesmartinterviewassignment.models.ControlDevice
import com.oshan.onesmartinterviewassignment.models.DashboardModel


class DashboardsFragment : Fragment() {


    lateinit var viewBinding: FragmentDashboardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentDashboardsBinding.inflate(inflater)
        return viewBinding.root
    }

    private lateinit var addedDashboardsAdapter: AddedDashboardsAdapter

    private val addDashboardList = ArrayList<DashboardModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        generateData()

        addedDashboardsAdapter = AddedDashboardsAdapter(addDashboardList) {  }
        viewBinding.rvAddedDashboards.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewBinding.rvAddedDashboards.adapter = addedDashboardsAdapter

        val dashboardDataFragmentPagerAdapter = DashboardDataFragmentPagerAdapter(requireActivity(), addDashboardList)
        viewBinding.viewPagerDashboardData.adapter = dashboardDataFragmentPagerAdapter

        viewBinding.circleIndicator.setViewPager(viewBinding.viewPagerDashboardData)
        dashboardDataFragmentPagerAdapter.registerAdapterDataObserver(viewBinding.circleIndicator.adapterDataObserver)
    }

    private fun generateData() {

        addDashboardList.add(DashboardModel("Living Room", R.drawable.ic_living_room))
        addDashboardList.add(DashboardModel("Patio", R.drawable.ic_patio))
        addDashboardList.add(DashboardModel("Bed Room", R.drawable.ic_bed_room))

        for (dashboard in addDashboardList) {
            dashboard.controlDeviceList = generateControlDevice(dashboard.name)
        }

    }

    private fun generateControlDevice(dashboardName: String): ArrayList<ControlDevice> {
        val deviceList = ArrayList<ControlDevice>()
        for (i in 0..20) {
            if (i % 2 == 0) {
                deviceList.add(ControlDevice("Stairway Switch", dashboardName, false, true, R.drawable.ic_switch_1, false))
            } else {
                deviceList.add(ControlDevice("Shade Light", dashboardName, true, true, R.drawable.ic_switch_2, false))
            }
        }
        deviceList[1].specialFeature = true

        return deviceList
    }

    private inner class DashboardDataFragmentPagerAdapter(fm: FragmentActivity, val dashboardList: ArrayList<DashboardModel>) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int = dashboardList.size

        override fun createFragment(position: Int): Fragment {
            return DashboardDataFragment.newInstance(dashboardList[position])
        }
    }

}