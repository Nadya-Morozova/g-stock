package com.ndmrzzzv.giphystock.fragment.main.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.giphystock.databinding.ItemGifBinding

class GifViewHolder(
    private val binding: ItemGifBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gif: Gif) {
        binding.apply {
            Glide
                .with(imgGif.context)
                .load(gif.url)
                .transform(RoundedCorners(24))
                .into(imgGif)

            tvTitle.text = gif.title
        }
    }

}