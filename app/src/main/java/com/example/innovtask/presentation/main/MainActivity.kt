package com.example.innovtask.presentation.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.innovtask.R
import com.example.innovtask.databinding.ActivityMainBinding
import com.example.innovtask.presentation.main.adapter.ScreenPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var _screenPagerAdapter: ScreenPagerAdapter? = null
    private val screenPagerAdapter get() = _screenPagerAdapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)
        setupViewPagerWithTabLayout()

    }

    private fun setupViewPagerWithTabLayout() {
        _screenPagerAdapter =
            ScreenPagerAdapter(3, supportFragmentManager, lifecycle)
        binding.userFragmentPager.adapter = screenPagerAdapter

        binding.screensTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.userFragmentPager.setCurrentItem(tab?.position ?: 0, false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}