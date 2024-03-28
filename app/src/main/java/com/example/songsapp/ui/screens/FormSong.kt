package com.example.songsapp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.songsapp.models.Song
import com.example.songsapp.persistences.AppDatabase
import com.example.songsapp.persistences.SongDao
import kotlinx.coroutines.launch
import java.util.UUID


@Composable
fun FormSong (SongDao: SongDao){

    val scope = rememberCoroutineScope()

    val judul = remember {
        mutableStateOf( TextFieldValue(""))
    }
    val penulis = remember {
        mutableStateOf( TextFieldValue(""))
    }
    val komponis = remember {
        mutableStateOf( TextFieldValue(""))
    }
    val genre = remember {
        mutableStateOf( TextFieldValue(""))
    }
    val artis = remember {
        mutableStateOf( TextFieldValue(""))
    }

    Column (modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Judul Lagu", modifier = Modifier.weight(1f))
            TextField(value = judul.value, onValueChange = {
                judul.value = it
            }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Penulis/Pencipta", modifier = Modifier.weight(1f))
            TextField(value = penulis.value, onValueChange = {
                penulis.value = it
            }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Komponis", modifier = Modifier.weight(1f))
            TextField(value = komponis.value, onValueChange = {
                komponis.value = it
            }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Genre", modifier = Modifier.weight(1f))
            TextField(value = genre.value, onValueChange = {
                genre.value = it
            }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Text(text = "Artis", modifier = Modifier.weight(1f))
            TextField(value = artis.value, onValueChange = {
                artis.value = it
            }, modifier = Modifier.weight(1f))
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Button(onClick = {
                val item = Song(UUID.randomUUID().toString(), judul.value.text, penulis.value.text, komponis.value.text, genre.value.text, artis.value.text)
                SongDao.upsert(item)

            }, modifier = Modifier.weight(1f)) {
                Text(text = "Simpan")
            }
        }
        Row(modifier = Modifier.fillMaxWidth()){
            Button(onClick = {
                judul.value = TextFieldValue("")
                penulis.value = TextFieldValue("")
                komponis.value = TextFieldValue("")
                genre.value = TextFieldValue("")
                artis.value = TextFieldValue("")
            }, modifier = Modifier.weight(1f)) {
                Text(text = "Batal")
            }
        }
    }
}