package com.example.android.androidbeer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.android.androidbeer.databinding.FragmentRecyclerBinding
import com.example.android.androidbeer.models.PubModel
import com.example.android.androidbeer.models.Pubs
import com.example.android.androidbeer.recyclerviews.PubAdapter
import com.example.android.androidbeer.tools.JsonLoader
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONObject


class RecyclerFragment : Fragment() {

    private var _binding : FragmentRecyclerBinding? = null
    private val binding get() = _binding!!
//    private val userList : ArrayList<Pub> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val json = JsonLoader.openJson(container!!.context, "pubs.json")!!
        val pubs = Gson().fromJson(json, Pubs::class.java)
        val adapter = PubAdapter(pubs.elements)
        binding.rvPubs.adapter = adapter
        binding.rvPubs.layoutManager = LinearLayoutManager(this.context)
        return binding.root
    }

}