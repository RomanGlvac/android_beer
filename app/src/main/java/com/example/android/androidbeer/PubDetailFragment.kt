package com.example.android.androidbeer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.androidbeer.databinding.FragmentPubDetailBinding


class PubDetailFragment : Fragment() {

    private lateinit var binding : FragmentPubDetailBinding
    private val args : PubDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPubDetailBinding.inflate(inflater, container, false)
        initTextBoxes()
        return binding.root
    }

    private fun initTextBoxes(){
        binding.apply {
            tvTitle.text = args.name
            tvWebsite.text = args.website
            tvOperator.text = args.operator
        }
    }

}