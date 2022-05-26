package com.example.mvvmapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.model.data.Author

class MyAdapter(
    private val list: List<Author>,
    private val clickItem: (name: String) -> Unit
) : RecyclerView.Adapter<MyAdapter.ViewHolderMyAdapter>() {
    class ViewHolderMyAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameTextView: TextView? = null
        var lastNameTextView: TextView? = null

        init {
            nameTextView = itemView.findViewById(R.id.txtTitle)
            lastNameTextView = itemView.findViewById(R.id.txtAuthor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMyAdapter {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ViewHolderMyAdapter(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderMyAdapter, position: Int) {
        holder.nameTextView?.text = list[position].name
        holder.lastNameTextView?.text = list[position].fathername

        holder.itemView.setOnClickListener {
            clickItem(list[position].name)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
