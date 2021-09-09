package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.kabos.viewpagersample.databinding.FragmentABinding
import com.kabos.viewpagersample.databinding.FragmentMainBinding
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding

class FragmentMain: Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ViewPagerAdapter
    private val viewModel by activityViewModels<PagerViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ViewPagerAdapter(this)
        val viewPager = binding.pager
        viewPager.adapter = adapter

        //setup TabLayout
        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = "$position"
        }.attach()


        viewModel.flag.observe(viewLifecycleOwner,{ replacePattern ->
            adapter.addFragment(replacePattern)
        })


    }
}
