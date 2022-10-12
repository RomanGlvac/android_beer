package com.example.android.androidbeer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
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
            (activity as MainActivity).pubHolder.removePub(args.position)
            val action = PubDetailFragmentDirections.actionPubDetailFragmentToRecyclerFragment3()
            binding.root.findNavController().navigate(action)
        }
    }

}