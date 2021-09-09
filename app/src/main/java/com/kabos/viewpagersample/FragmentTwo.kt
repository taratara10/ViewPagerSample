package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding
import com.kabos.viewpagersample.databinding.FragmentSampleTwoBinding

class FragmentTwo: Fragment() {
    private lateinit var binding: FragmentSampleTwoBinding
    private val viewModel by activityViewModels<PagerViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSampleTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReplaceAb.setOnClickListener {
            viewModel.flag.postValue(ReplacePattern.AB)
        }

    }
}
