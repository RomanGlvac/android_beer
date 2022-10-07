package com.example.android.androidbeer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.androidbeer.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment() {

    private var _binding : FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val todos = listOf(
            Todo("Learn Kotlin"),
            Todo("Learn Android development")
        )
        val adapter = TodoAdapter(todos)
        binding.rvStuff.adapter = adapter
        binding.rvStuff.layoutManager = LinearLayoutManager(container?.context)
        return binding.root
    }


}