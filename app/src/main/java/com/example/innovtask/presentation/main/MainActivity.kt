package com.example.innovtask.presentation.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.innovtask.R
import com.example.innovtask.databinding.ActivityMainBinding
import com.example.innovtask.presentation.main.adapter.ScreenPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var _screenPagerAdapter: ScreenPagerAdapter? = null
    private val screenPagerAdapter get() = _screenPagerAdapter!!
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupViewPagerWithTabLayout()
        requestData()
        observeData()

    }

    private fun requestData() {
        viewModel.getCoachName()
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.coachState.collectLatest {
                    binding.cocahName.text = it
                }
            }
        }
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