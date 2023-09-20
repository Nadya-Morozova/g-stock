package com.ndmrzzzv.giphystock.fragment.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.ndmrzzzv.giphystock.databinding.FragmentDetailGifBinding
import com.ndmrzzzv.giphystock.fragment.features.FullscreenFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailGifBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailGifBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FullscreenFragment.show(activity?.window, binding.root)

        viewModel.getInfoAboutGif(args.id)

        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.gif.observe(viewLifecycleOwner) { gif ->
            if (gif == null) {
                binding.progressBar.visibility = View.GONE
                binding.tvMessage.visibility = View.VISIBLE
            }

            Glide
                .with(requireContext())
                .load(gif?.url)
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
                .apply(
                    RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(binding.imgGif)
        }
    }

}