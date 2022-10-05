package com.example.android.androidbeer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.androidbeer.databinding.FragmentFormBinding


class FormFragment : Fragment() {

    private var _binding : FragmentFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        binding.btnContinue.setOnClickListener {
            val action = FormFragmentDirections.actionFormFragmentToAnimationFragment(
                binding.etUserName.text.toString(),
                binding.etEstablishmentName.text.toString(),
                binding.etLatitude.text.toString(),
                binding.etLongitude.text.toString()
            )
            it.findNavController().navigate(action)
        }
        return binding.root
    }

}