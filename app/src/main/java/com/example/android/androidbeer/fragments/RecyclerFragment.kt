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

    private lateinit var binding: FragmentRecyclerBinding
    private val viewModel: PubListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.rvPubs.adapter = PubAdapter(
            deleteListener = { position -> viewModel.deletePub(position) },
            clickListener = { position -> Log.d("clickListener", "Clicked at $position") }
        )
        binding.rvPubs.layoutManager = LinearLayoutManager(binding.root.context)
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshPubs()
            binding.swipeRefreshLayout.isRefreshing = false
        }
        return binding.root
    }

}