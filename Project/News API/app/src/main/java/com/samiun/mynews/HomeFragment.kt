package com.samiun.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.samiun.mynews.adapter.ViewpagerAdapter
import com.samiun.mynews.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.tabLayout
        val viewpage = binding.viewPager2
        val tabAdapter = ViewpagerAdapter(childFragmentManager,lifecycle)
        viewpage.adapter = tabAdapter
        TabLayoutMediator(tabLayout,viewpage){  tab,position->
            when(position){
                0-> {
                    tab.text = "Top News"
                }
                1-> {
                    tab.text = "BBC"
                }
                2->{
                    tab.text = "CNN"
            }
            }
        }.attach()
    }
}