package org.ericampire.android.demoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import org.ericampire.android.demoapp.Fact
import org.ericampire.android.demoapp.databinding.ItemListBinding

class ItemAdapter : ListAdapter<Fact, ItemViewHolder>(ItemAdapter) {
    companion object : DiffUtil.ItemCallback<Fact>() {
        override fun areItemsTheSame(oldItem: Fact, newItem: Fact): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Fact, newItem: Fact): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val binding = holder.binding as ItemListBinding
        binding.fact = getItem(position)
        binding.executePendingBindings()
    }
}

class ItemViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)