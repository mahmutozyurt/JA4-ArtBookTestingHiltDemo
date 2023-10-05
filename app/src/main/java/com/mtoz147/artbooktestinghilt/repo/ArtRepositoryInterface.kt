package com.mtoz147.artbooktestinghilt.repo

import androidx.lifecycle.LiveData
import com.mtoz147.artbooktestinghilt.roomdb.Art
import com.mtoz147.artbooktestinghilt.model.ImageResponse
import com.mtoz147.artbooktestinghilt.util.Resource


//this interface has been created for testing purpose
interface ArtRepositoryInterface {
    suspend fun insertArt(art: Art)
    suspend fun deleteArt(art: Art)

    fun getArt():LiveData<List<Art>>
    suspend fun searchImage(imageString: String):Resource<ImageResponse>

}