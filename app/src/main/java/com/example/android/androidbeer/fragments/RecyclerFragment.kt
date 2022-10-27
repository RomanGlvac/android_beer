package com.example.android.androidbeer.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.androidbeer.databinding.FragmentRecyclerBinding
import com.example.android.androidbeer.recyclerviews.PubAdapter
import com.example.android.androidbeer.recyclerviews.RecyclerViewClickListener
import com.example.android.androidbeer.recyclerviews.RecyclerViewSortingListener
import com.example.android.androidbeer.tools.PubManager
import com.example.android.androidbeer.viewmodel.PubListViewModel
import java.util.*


class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PubListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.rvPubs.adapter = PubAdapter(
            deleteListener = { position -> viewModel.deletePub(position) },
            clickListener = { position -> Log.d("clickListener", "Clicked at $position") }
        )
        binding.rvPubs.layoutManager = LinearLayoutManager(binding.root.context)
        return binding.root
    }

//
//    private fun setButtonListeners(){
//        binding.apply {
//            val adapter = rvPubs.adapter as PubAdapter
//            btnSortAsc.setOnClickListener{ adapter.sortItems() }
//            btnSortDesc.setOnClickListener{ adapter.sortItems(true) }
//        }
//    }

}