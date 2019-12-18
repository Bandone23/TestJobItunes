package com.example.mytestitunesnew.data.repository

import com.example.mytestitunesnew.data.remote.model.toSongs
import com.example.mytestitunesnew.data.remote.source.SongRemoteDatSource
import com.example.mytestitunesnew.domain.model.SongList

class SongRepository(
    private val songRemoteDatSource: SongRemoteDatSource
) {
    suspend fun getSong():List<SongList> {
        return songRemoteDatSource.getSong().map { it.toSongs() }
    }
}