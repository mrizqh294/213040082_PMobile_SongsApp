package com.example.songsapp.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.songsapp.persistences.AppDatabase
import androidx.room.Room


@Composable

fun SongScreen(){
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    val songDao = db.songDao()

    FormSong(songDao)
    ListSong(songDao)

}

