package com.example.fragments

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.fragments.databinding.ItemPortretsBinding

class PortraitAdapter (val portretList: ArrayList<Item>,
                       val onClick :(position: Int) -> Unit
):
    RecyclerView.Adapter<PortraitAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPortretsBinding.inflate(LayoutInflater.from(parent.context),parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portretList[position]
         )
    }

    override fun getItemCount() = portretList.size


    inner class ViewHolder(private val binding: ItemPortretsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.imageView.setImageResource(item.image)
            itemView.setOnClickListener {
                onClick(adapterPosition)

            }

            binding.text1.text = item.text1
            binding.text2.text = item.text2


        }
    }
}



