package com.example.mytestitunesnew.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.core.extension.LiveResult
import com.example.mytestitunesnew.domain.model.SongList
import com.example.mytestitunesnew.domain.usecase.GetSongUseCase
import com.example.mytestitunesnew.ui.adapter.SongAdapter

class SongViewModel(
    private val getSongUseCase: GetSongUseCase
): ViewModel() {
    lateinit var adapter: SongAdapter
    val songLiveData = LiveResult<List<SongList>>()


    fun getSong(){
        getSongUseCase.execute(liveData = songLiveData)
    }

    fun initAdapter(clickListener:(SongList,Int)-> Unit){
        adapter = SongAdapter(mutableListOf(),clickListener)
    }

    fun updateSong(songList: List<SongList>) {
        adapter.setData(songList)
        adapter.notifyDataSetChanged()
    }

}