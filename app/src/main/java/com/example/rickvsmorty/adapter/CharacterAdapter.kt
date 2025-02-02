package com.example.rickvsmorty.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.rickvsmorty.databinding.CharacterLayoutBinding
import com.example.rickvsmorty.model.RickMorty

class CharacterAdapter : PagingDataAdapter<RickMorty, CharacterAdapter.ImageViewHolder>(diffCallback) {

    inner class ImageViewHolder(val binding: CharacterLayoutBinding) : ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CharacterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {
            holder.itemView.apply {
                tvDescription.text = "${currChar?.name}"
                val imageLink = currChar?.image
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }
}