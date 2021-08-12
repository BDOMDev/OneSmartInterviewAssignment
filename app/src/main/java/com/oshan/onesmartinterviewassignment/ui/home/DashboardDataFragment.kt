package com.oshan.onesmartinterviewassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.oshan.onesmartinterviewassignment.R
import com.oshan.onesmartinterviewassignment.databinding.FragmentDashboardDataBinding
import com.oshan.onesmartinterviewassignment.models.DashboardModel


class DashboardDataFragment : Fragment() {

    lateinit var viewBinding: FragmentDashboardDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentDashboardDataBinding.inflate(inflater)
        return viewBinding.root
    }

    lateinit var dashboardModel: DashboardModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardModel = requireArguments().getParcelable<DashboardModel>(PARAM_DATA)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.txtDashboardName.text = "${dashboardModel.name} Dashboard"

        viewBinding.rvDashboardControlls.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        val dashboardDataAdapter = DashboardDataAdapter(dashboardModel.controlDeviceList)
        viewBinding.rvDashboardControlls.adapter  = dashboardDataAdapter


    }

    companion object {

        const val PARAM_DATA = "data"

        fun newInstance(dashboardModel: DashboardModel): DashboardDataFragment {
            return DashboardDataFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PARAM_DATA, dashboardModel)
                }
            }
        }
    }

}