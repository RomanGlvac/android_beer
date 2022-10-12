package com.example.android.androidbeer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.android.androidbeer.databinding.FragmentRecyclerBinding
import com.example.android.androidbeer.models.PubModel
import com.example.android.androidbeer.models.Pubs
import com.example.android.androidbeer.recyclerviews.PubAdapter
import com.example.android.androidbeer.recyclerviews.RecyclerViewClickListener
import com.example.android.androidbeer.tools.JsonLoader
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONObject


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

    private fun initRecyclerView(container : ViewGroup){
        val json = JsonLoader.openJson(container!!.context, "pubs.json")!!
        val pubs = Gson().fromJson(json, Pubs::class.java)
        val adapter = PubAdapter(pubs.elements, object : RecyclerViewClickListener {
            override fun onClick(position: Int) {
                val pub = pubs.elements[position]
                val action = RecyclerFragmentDirections.actionRecyclerFragmentToPubDetailFragment(
                    pub.tags.name,
                    pub.tags.website,
                    pub.tags.operator
                )
                container.findNavController().navigate(action)
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