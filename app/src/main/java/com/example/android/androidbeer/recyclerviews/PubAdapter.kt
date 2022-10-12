package com.example.android.androidbeer.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.text.capitalize
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.databinding.ItemPubBinding
import com.example.android.androidbeer.models.PubModel
import java.util.*
import kotlin.collections.ArrayList

class PubAdapter(
    private val pubList : ArrayList<PubModel>,
    private val clickListener : RecyclerViewClickListener
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
            tvWebsite.text = pubList[position].tags.website
        }
    }

    override fun getItemCount(): Int {
        return pubList.size
    }

    @Suppress("SENSELESS_COMPARISON")
    fun sortItems(descending : Boolean = false){
        if (!descending) {
            pubList.sortBy { if(it.tags.name != null) {
                it.tags.name.uppercase()
            } else {
                it.tags.name }
            }
        } else {
            pubList.sortByDescending { if(it.tags.name != null) {
                it.tags.name.uppercase()
            } else {
                it.tags.name } }
        }
        notifyDataSetChanged()
    }

    inner class PubViewHolder(val binding : ItemPubBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener{
                clickListener.onClick(absoluteAdapterPosition)
            }
            binding.btnDelete.setOnClickListener {
                val position = absoluteAdapterPosition
                pubList.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

}