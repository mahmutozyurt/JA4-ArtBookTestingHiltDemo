package com.mtoz147.artbooktestinghilt.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
/*import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query*/

@Dao
interface ArtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertArt(art: Art)
    @Delete
    fun deleteArt(art: Art)
    @Query("SELECT * FROM arts")
    fun observeArts():LiveData<List<Art>>
}