
package com.example.viewpager2withtablayout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assesmen1_ppbm.DevProfileFragment
import com.example.assesmen1_ppbm.DevStatisticFragment


private const val NUM_TABS = 2

public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return DevStatisticFragment()
            1 -> return DevProfileFragment()
        }
        return DevProfileFragment()
    }
}