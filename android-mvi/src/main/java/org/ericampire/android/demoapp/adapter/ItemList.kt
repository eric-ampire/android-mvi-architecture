package org.ericampire.android.demoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.api.load
import coil.transform.CircleCropTransformation
import org.ericampire.android.demoapp.R
import org.ericampire.android.demoapp.model.User
import org.ericampire.android.demoapp.databinding.ItemListBinding

class ItemAdapter : ListAdapter<User, ItemViewHolder>(ItemAdapter) {
    companion object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
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
        val currentUser = getItem(position)
        binding.run {
            user = currentUser
            executePendingBindings()
        }
    }
}

class ItemViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)