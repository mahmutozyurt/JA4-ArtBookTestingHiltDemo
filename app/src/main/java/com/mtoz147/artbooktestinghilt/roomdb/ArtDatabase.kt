package com.mtoz147.artbooktestinghilt.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtoz147.artbooktestinghilt.model.Art

@Database(entities = [Art::class], version = 1)
abstract class ArtDatabase :RoomDatabase(){
    abstract fun artDao():ArtDao
}