package com.ndmrzzzv.giphystock.fragment.main.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ndmrzzzv.domain.model.Gif
import com.ndmrzzzv.giphystock.databinding.ItemGifBinding
import com.ndmrzzzv.giphystock.fragment.main.view.holder.GifViewHolder
import com.ndmrzzzv.giphystock.fragment.main.view.interfaces.NavigateToGifListener

class GifAdapter(
    private var gifs: List<Gif>,
    private val navigateToGifListener: NavigateToGifListener
) : RecyclerView.Adapter<GifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val binding = ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GifViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val gif = gifs[position]
        holder.bind(gif)

        holder.itemView.setOnClickListener {
            navigateToGifListener.navigate(gif.id ?: "")
        }
    }

    override fun getItemCount(): Int = gifs.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(listOfGifs: List<Gif>) {
        gifs = listOfGifs
        notifyDataSetChanged()
    }
}