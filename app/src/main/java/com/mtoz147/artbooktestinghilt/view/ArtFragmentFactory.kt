package com.mtoz147.artbooktestinghilt.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.mtoz147.artbooktestinghilt.adapter.ArtRecyclerAdapter
import com.mtoz147.artbooktestinghilt.adapter.ImageRecyclerAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


//https://proandroiddev.com/android-fragments-fragmentfactory-ceec3cf7c959
class ArtFragmentFactory @Inject constructor(
    private val imageRecyclerAdapter: ImageRecyclerAdapter,
    private val glide:RequestManager,
    private val artRecyclerAdapter: ArtRecyclerAdapter
):FragmentFactory()    {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ImageApiFragment::class.java.name->ImageApiFragment(imageRecyclerAdapter)
            ArtDetailsFragment::class.java.name->ArtDetailsFragment(glide)
            ArtFragment::class.java.name->ArtFragment(artRecyclerAdapter)
            else->super.instantiate(classLoader, className)
        }

    }
}