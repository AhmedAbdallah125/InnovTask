package com.example.innovtask.presentation.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.innovtask.presentation.classes.ClassesFragment
import com.example.innovtask.presentation.community.CommunityFragment
import com.example.innovtask.presentation.overview.OverviewFragment

class ScreenPagerAdapter(
    private val pageCount: Int,
    fm: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = pageCount
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                OverviewFragment()
            }

            1 -> {
                CommunityFragment()
            }

            2 -> {
                ClassesFragment()
            }

            else -> {
                Fragment()
            }

        }

    }
}