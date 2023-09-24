package com.mtoz147.artbooktestinghilt.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mtoz147.artbooktestinghilt.R
import com.mtoz147.artbooktestinghilt.databinding.FragmentArtsBinding

class ArtFragment:Fragment(R.layout.fragment_arts) {
    private var fragmentArtsBinding:FragmentArtsBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentArtsBinding.bind(view)
        fragmentArtsBinding=binding
        binding.fab.setOnClickListener {
            findNavController().navigate(ArtFragmentDirections.actionArtFragmentToArtDetailsFragment())
        }

    }
    override fun onDestroyView(){
        fragmentArtsBinding=null
        super.onDestroyView()
    }
}