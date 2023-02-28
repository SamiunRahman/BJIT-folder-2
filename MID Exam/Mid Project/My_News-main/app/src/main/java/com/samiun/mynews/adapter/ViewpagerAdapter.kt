package com.samiun.mynews.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.samiun.mynews.databinding.FragmentNewsBinding
import com.samiun.mynews.overview.NewsFragment

class ViewpagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
    return 3
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                NewsFragment()
            }
            1-> {
                NewsFragment()

            }
            else->{
                NewsFragment()
            }
        }
    }

}
