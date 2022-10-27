package com.example.android.androidbeer.recyclerviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.databinding.FragmentPubDetailBinding
import com.example.android.androidbeer.databinding.ItemPubBinding
import com.example.android.androidbeer.models.PubModel
import com.example.android.androidbeer.viewmodel.PubListViewModel
import kotlin.collections.ArrayList

class PubAdapter(
    val deleteListener: (Int) -> Unit,
    val clickListener: (Int) -> Unit
) : ListAdapter<PubModel, PubAdapter.PubViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<PubModel>() {
        override fun areItemsTheSame(oldItem: PubModel, newItem: PubModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PubModel, newItem: PubModel): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PubViewHolder {
        // Creating an instance of the view which holds a single recycler view item.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPubBinding.inflate(layoutInflater, parent, false)
        return PubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PubViewHolder, position: Int) {
        val currentPub = getItem(position)
        holder.bind(currentPub)
    }


    inner class PubViewHolder(private val binding: ItemPubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pubModel: PubModel) {
            binding.apply {
                tvTitle.text = pubModel.pubInfo.name
                tvWebsite.text = pubModel.pubInfo.website
                btnDelete.setOnClickListener {
                    val position = absoluteAdapterPosition
                    deleteListener(position)
                    notifyItemRemoved(position)
                }
            }
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                clickListener(position)
            }
        }
    }
}