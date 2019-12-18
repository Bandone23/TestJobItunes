package com.example.mytestitunesnew.data.remote.source

import com.example.core.extension.await
import com.example.mytestitunesnew.data.remote.model.SongListEntry
import com.example.mytestitunesnew.data.remote.net.SongRemoteApi

open class SongRemoteDatSource(
    private val songRemoteApi: SongRemoteApi
) {
    suspend fun getSong():List<SongListEntry>{
        return songRemoteApi.getSong().await()!!.results
    }
}