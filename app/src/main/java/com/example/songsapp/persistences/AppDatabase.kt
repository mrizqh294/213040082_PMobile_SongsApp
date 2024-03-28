package com.example.songsapp.persistences


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.songsapp.models.Song


@Database(entities = [Song::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao

    companion object {
        const val DATABASE_NAME = "song-database"
    }
}