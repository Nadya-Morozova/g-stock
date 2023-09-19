package com.ndmrzzzv.giphystock.fragment.main.view.holder

import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
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
                .listener(object : RequestListener<Drawable> {
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .transform(RoundedCorners(24))
                .apply(
                    RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(imgGif)

            tvTitle.text = gif.title
        }
    }

}