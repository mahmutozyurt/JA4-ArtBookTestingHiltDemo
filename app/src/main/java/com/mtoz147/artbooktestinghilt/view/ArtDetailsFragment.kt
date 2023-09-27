package com.mtoz147.artbooktestinghilt.view

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.mtoz147.artbooktestinghilt.R
import com.mtoz147.artbooktestinghilt.databinding.FragmentArtDetailsBinding
import javax.inject.Inject

class ArtDetailsFragment @Inject constructor(
    private val glide:RequestManager
): Fragment(R.layout.fragment_art_details){
    private var artDetailsBinding:FragmentArtDetailsBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtDetailsBinding.bind(view)
        artDetailsBinding=binding
        binding.artImageView.setOnClickListener{
            findNavController().navigate(ArtDetailsFragmentDirections.actionArtDetailsFragmentToImageApiFragment())
        }
        val callback= object : OnBackPressedCallback(enabled = true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onDestroyView() {
        artDetailsBinding=null
        super.onDestroyView()
    }
}