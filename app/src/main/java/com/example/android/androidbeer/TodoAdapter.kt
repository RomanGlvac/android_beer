package com.example.android.androidbeer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.androidbeer.databinding.ItemTodoBinding

class TodoAdapter(
    val todos:List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // Creating an instance of the view which holds a single recycler view item.
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // Binding data to items.
        holder.binding.apply {
            tvTitle.text = todos[position].title
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    inner class TodoViewHolder(val binding : ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)
}