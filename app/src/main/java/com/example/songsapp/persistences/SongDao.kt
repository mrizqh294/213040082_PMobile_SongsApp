package com.example.songsapp.persistences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.songsapp.models.Song

@Dao
interface SongDao {
    @Query("select * from song")
    fun loadAll(): LiveData<List<Song>>

//    @Query("select * from song where id = :id")
//    fun load(id: String): LiveData<Song>

    @Query("select * from song where id = :id")
    fun getById(id: String): Song?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg items: Song)

    @Query("delete from Song where id = :id")
    fun delete(id: String)

    @Delete
    fun delete(item: Song)
}