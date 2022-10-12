package com.example.android.androidbeer.recyclerviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.databinding.ItemPubBinding
import com.example.android.androidbeer.models.PubModel
import kotlin.collections.ArrayList

class PubAdapter(
    val pubList : ArrayList<PubModel>,
) : RecyclerView.Adapter<PubAdapter.PubViewHolder>(){

    private lateinit var clickListener : RecyclerViewClickListener
    private lateinit var sortListener: RecyclerViewSortingListener

    fun setClickListener(listener: RecyclerViewClickListener){
        clickListener = listener
    }

    fun setSortListener(listener: RecyclerViewSortingListener){
        sortListener = listener
    }

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

    @SuppressLint("NotifyDataSetChanged")
    fun sortItems(desc : Boolean = false){
        sortListener.sortItems(desc)
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