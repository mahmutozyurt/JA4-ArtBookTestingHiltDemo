package com.mtoz147.artbooktestinghilt.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mtoz147.artbooktestinghilt.R
import com.mtoz147.artbooktestinghilt.adapter.ImageRecyclerAdapter
import javax.inject.Inject

class ImageApiFragment @Inject constructor(
    private val imageRecyclerAdapter: ImageRecyclerAdapter
):Fragment(R.layout.fragment_image_api) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}