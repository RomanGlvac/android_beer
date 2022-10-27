package com.example.android.androidbeer.recyclerviews

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.models.PubModel

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, pubHolder: PubHolder?){
    val adapter = recyclerView.adapter as PubAdapter
    adapter.submitList(pubHolder?.pubs)
}