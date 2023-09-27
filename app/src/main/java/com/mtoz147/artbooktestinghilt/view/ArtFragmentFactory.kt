package com.mtoz147.artbooktestinghilt.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import javax.inject.Inject


//https://proandroiddev.com/android-fragments-fragmentfactory-ceec3cf7c959
class ArtFragmentFactory @Inject constructor(
    private val glide:RequestManager
):FragmentFactory()    {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            ArtDetailsFragment::class.java.name->ArtDetailsFragment(glide)
            else->super.instantiate(classLoader, className)
        }

    }
}