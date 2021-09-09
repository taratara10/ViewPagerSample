package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kabos.viewpagersample.databinding.FragmentBBinding
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding

class FragmentB: Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }
}
