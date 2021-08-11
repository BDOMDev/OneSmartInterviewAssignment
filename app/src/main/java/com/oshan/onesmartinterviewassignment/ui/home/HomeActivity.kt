package com.oshan.onesmartinterviewassignment.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.oshan.onesmartinterviewassignment.R
import com.oshan.onesmartinterviewassignment.databinding.ActivityHomeBinding
import com.oshan.onesmartinterviewassignment.utils.StatusBarUtils

class HomeActivity : AppCompatActivity() {

    lateinit var viewBindings : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindings = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBindings.root)
        StatusBarUtils.setSystemUiLightStatusBar(this.window, true)

        configUI()
        configListeners()

    }

    private fun configUI() {
        viewBindings.mainViewPager.adapter = MainFragmentPagerAdapter(this)
    }

    private fun configListeners() {
        viewBindings.btnDashboards.setOnClickListener {
            viewBindings.btnScene.setBackgroundResource(R.drawable.shape_inactive_button)
            viewBindings.btnDashboards.setBackgroundResource(R.drawable.shape_active_button)
            viewBindings.mainViewPager.setCurrentItem(0, true)
        }
        viewBindings.btnScene.setOnClickListener {
            viewBindings.btnScene.setBackgroundResource(R.drawable.shape_active_button)
            viewBindings.btnDashboards.setBackgroundResource(R.drawable.shape_inactive_button)
            viewBindings.mainViewPager.setCurrentItem(1, true)
        }
    }

    private inner class MainFragmentPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) DashboardsFragment() else SceneFragment()
        }
    }

}