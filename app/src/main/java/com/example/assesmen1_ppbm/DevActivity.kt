package com.example.assesmen1_ppbm
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assesmen1_ppbm.databinding.ActivityDevBinding
import com.example.viewpager2withtablayout.adapter.ViewPagerAdapter

import com.google.android.material.tabs.TabLayoutMediator

val animalsArray = arrayOf(
    "Statistic",
    "Dev Profile"
)

class DevActivity : AppCompatActivity() {
    lateinit var binding: ActivityDevBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDevBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()
    }
}