package com.example.android.androidbeer.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.databinding.ItemPubBinding
import com.example.android.androidbeer.models.PubModel

class PubAdapter(
    val pubList : ArrayList<PubModel>
) : RecyclerView.Adapter<PubAdapter.PubViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PubViewHolder {
        // Creating an instance of the view which holds a single recycler view item.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPubBinding.inflate(layoutInflater, parent, false)
        return PubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PubViewHolder, position: Int) {
        // Binding data to items.
        holder.binding.apply {
            tvTitle.text = pubList[position].tags.name
        }
    }

    override fun getItemCount(): Int {
        return pubList.size
    }

    inner class PubViewHolder(val binding : ItemPubBinding) : RecyclerView.ViewHolder(binding.root)
}