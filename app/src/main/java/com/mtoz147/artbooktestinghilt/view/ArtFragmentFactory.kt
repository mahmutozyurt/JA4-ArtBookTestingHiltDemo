package com.mtoz147.artbooktestinghilt.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.mtoz147.artbooktestinghilt.adapter.ArtRecyclerAdapter
import com.mtoz147.artbooktestinghilt.adapter.ImageRecyclerAdapter
import javax.inject.Inject


//https://proandroiddev.com/android-fragments-fragmentfactory-ceec3cf7c959
class ArtFragmentFactory @Inject constructor(
    private val artRecyclerAdapter: ArtRecyclerAdapter,
    private val glide:RequestManager,
    private val imageRecyclerAdapter: ImageRecyclerAdapter
):FragmentFactory()    {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){

            ArtFragment::class.java.name->ArtFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name->ArtDetailsFragment(glide)
            ImageApiFragment::class.java.name->ImageApiFragment(imageRecyclerAdapter)
            else->super.instantiate(classLoader, className)
        }

    }
}