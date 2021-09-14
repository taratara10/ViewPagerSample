package com.kabos.viewpagersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.kabos.viewpagersample.databinding.FragmentSampleOneBinding

class FragmentOne: Fragment() {
    private lateinit var binding: FragmentSampleOneBinding
    private val viewModel by activityViewModels<PagerViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSampleOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReplaceA.setOnClickListener {
                viewModel.flag.postValue(ReplacePattern.OneToA)
        }

    }
}
