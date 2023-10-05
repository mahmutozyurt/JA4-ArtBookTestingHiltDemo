package com.mtoz147.artbooktestinghilt.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mtoz147.artbooktestinghilt.model.ImageResponse
import com.mtoz147.artbooktestinghilt.roomdb.Art
import com.mtoz147.artbooktestinghilt.util.Resource

class FakeArtRepositoryTest:ArtRepositoryInterface {

   private val arts= mutableListOf<Art>()
       private val artsLiveData=MutableLiveData<List<Art>>(arts)

    override suspend fun insertArt(art: Art) {
        arts.add(art)
        refreshData()
    }

    override suspend fun deleteArt(art: Art) {
        arts.remove(art)
        refreshData()
    }

    override fun getArt(): LiveData<List<Art>> {
        return artsLiveData
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return Resource.success(ImageResponse(listOf(),0,0))
    }

    private fun refreshData(){
        artsLiveData.postValue(arts)
    }
}