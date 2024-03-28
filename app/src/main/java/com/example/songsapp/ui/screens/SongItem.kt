package com.example.songsapp.ui.screens


import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.songsapp.models.Song

@Composable
fun SongItem(item: Song){
    Row {
        Text(modifier = Modifier.weight(3f), text = item.judul)
        Text(modifier = Modifier.weight(3f), text = item.penulis)
        Text(modifier = Modifier.weight(3f), text = item.komponis)
        Text(modifier = Modifier.weight(3f), text = item.genre)
        Text(modifier = Modifier.weight(3f), text = item.artis)
    }
}