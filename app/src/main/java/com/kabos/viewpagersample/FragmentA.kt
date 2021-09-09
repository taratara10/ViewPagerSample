package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kabos.viewpagersample.databinding.FragmentABinding
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding

class FragmentA: Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }
}
