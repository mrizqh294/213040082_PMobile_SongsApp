package com.example.songsapp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import com.example.songsapp.models.Song
import com.example.songsapp.persistences.SongDao
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ListSong(songDao: SongDao){
    val _list: LiveData<List<Song>> = songDao.loadAll()
    val list: List<Song> by _list.observeAsState(listOf<Song>())

    Column (modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list.size){index ->
                val item = list[index]
                SongItem(item=item)
            }
        }
    }
}