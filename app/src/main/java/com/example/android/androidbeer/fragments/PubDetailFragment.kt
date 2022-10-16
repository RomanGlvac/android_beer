package com.example.android.androidbeer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.androidbeer.MainActivity
import com.example.android.androidbeer.databinding.FragmentPubDetailBinding
import com.example.android.androidbeer.tools.PubManager


class PubDetailFragment : Fragment() {

    private lateinit var binding : FragmentPubDetailBinding
    private val args : PubDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPubDetailBinding.inflate(inflater, container, false)
        initButton()
        initTextBoxes()
        return binding.root
    }

    private fun initTextBoxes(){
        binding.apply {
            tvTitle.text = args.name
            tvWebsite.text = args.website
            tvOperator.text = args.operator
            tvOpeningHours.text = args.openingHours
        }
    }

    private fun initButton(){
        binding.btnDelete.setOnClickListener {
            val activity : MainActivity = this.activity as MainActivity
            PubManager.getPubHolder(binding.root.context)!!.removePub(args.position)
            activity.onBackPressed()
        }
    }

}