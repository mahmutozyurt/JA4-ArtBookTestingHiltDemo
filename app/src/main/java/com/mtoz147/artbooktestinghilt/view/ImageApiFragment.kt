package com.mtoz147.artbooktestinghilt.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mtoz147.artbooktestinghilt.R
import com.mtoz147.artbooktestinghilt.adapter.ImageRecyclerAdapter
import com.mtoz147.artbooktestinghilt.databinding.FragmentImageApiBinding
import com.mtoz147.artbooktestinghilt.util.Status
import com.mtoz147.artbooktestinghilt.viewmodel.ArtViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ImageApiFragment @Inject constructor(
    val imageRecyclerAdapter: ImageRecyclerAdapter
):Fragment(R.layout.fragment_image_api) {

    lateinit var viewModel: ArtViewModel
    //lateinit var viewModel:ArtViewModel

    private var fragmentBinding:FragmentImageApiBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ArtViewModel::class.java)

        val binding = FragmentImageApiBinding.bind(view)
        fragmentBinding = binding

        var job: Job?=null

        binding.searchText.addTextChangedListener { editable ->
            job?.cancel()
            job = lifecycleScope.launch {
                delay(1000)
               /* val searchText = editable?.toString()
                if (!searchText.isNullOrEmpty()) {
                    viewModel.searchForImage(searchText)*/
                editable?.let {
                    if (it.toString().isEmpty()) {
                        viewModel.searchForImage(it.toString())
                    }
                }
            }
        }



        subscribeToObservers()

        binding.imageRecyclerView.adapter = imageRecyclerAdapter
        binding.imageRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        imageRecyclerAdapter.setOnItemClickListener {
            findNavController().popBackStack()
            viewModel.setSelectedImage(it)
        }

    }

   fun subscribeToObservers(){
        viewModel.imageList.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS->{
                    val urls=it.data?.hits?.map {imageResult ->
                        imageResult.previewURL
                    }
                    imageRecyclerAdapter.images=urls?: listOf()
                    fragmentBinding?.progressBar?.visibility=View.GONE
                }
                Status.ERROR->{
                    Toast.makeText(requireContext(),it.message?:"Error",Toast.LENGTH_LONG).show()
                    fragmentBinding?.progressBar?.visibility=View.GONE
                }
                Status.LOADING->{
                    fragmentBinding?.progressBar?.visibility=View.VISIBLE
                }
            }
        })
    }
    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }
}