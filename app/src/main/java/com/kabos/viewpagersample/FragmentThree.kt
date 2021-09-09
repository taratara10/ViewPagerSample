package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding
import com.kabos.viewpagersample.databinding.FragmentSampleThreeBinding

class FragmentThree: Fragment() {
    private lateinit var binding: FragmentSampleThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSampleThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
