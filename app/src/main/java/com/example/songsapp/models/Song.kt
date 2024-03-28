package com.example.songsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey
    val id: String,
    val judul: String,
    val penulis: String,
    val komponis: String,
    val genre: String,
    val artis: String,
)