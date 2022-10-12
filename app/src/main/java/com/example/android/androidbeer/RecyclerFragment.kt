package com.example.android.androidbeer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.androidbeer.databinding.FragmentRecyclerBinding
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.recyclerviews.PubAdapter
import com.example.android.androidbeer.recyclerviews.RecyclerViewClickListener
import com.example.android.androidbeer.recyclerviews.RecyclerViewSortingListener
import com.example.android.androidbeer.tools.JsonLoader
import com.google.gson.Gson
import java.util.*


class RecyclerFragment : Fragment() {

    private var _binding : FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        initRecyclerView(container!!)
        setButtonListeners()
        return binding.root
    }

    @Suppress("SENSELESS_COMPARISON")
    private fun initRecyclerView(container : ViewGroup){
        val pubs = (activity as MainActivity).pubHolder
        val adapter = PubAdapter(pubs.elements)
        adapter.setClickListener(object : RecyclerViewClickListener {
            override fun onClick(position: Int) {
                val pub = pubs.elements[position]
                val action = RecyclerFragmentDirections.actionRecyclerFragmentToPubDetailFragment(
                    pub.tags.name,
                    pub.tags.website,
                    pub.tags.operator,
                    position
                )
                container.findNavController().navigate(action)
            }
        })
        adapter.setSortListener(object : RecyclerViewSortingListener {
            override fun sortItems(desc: Boolean) {
                if(!desc){
                    adapter.pubList.sortBy {
                        if(it.tags.name != null){
                            it.tags.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            }
                        }
                        else { it.tags.name }
                    }
                } else {
                    adapter.pubList.sortByDescending {
                        if(it.tags.name != null){
                            it.tags.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            }
                        }
                        else { it.tags.name }
                    }
                }
            }
        })
        binding.rvPubs.adapter = adapter
        binding.rvPubs.layoutManager = LinearLayoutManager(this.context)
    }

    private fun setButtonListeners(){
        binding.apply {
            val adapter = rvPubs.adapter as PubAdapter
            btnSortAsc.setOnClickListener{ adapter.sortItems() }
            btnSortDesc.setOnClickListener{ adapter.sortItems(true) }
        }
    }

}