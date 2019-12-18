package com.example.mytestitunesnew.data.remote.net

import com.example.core.base.Response
import com.example.mytestitunesnew.data.remote.model.SongEntry
import retrofit2.Call
import retrofit2.http.GET

interface SongRemoteApi {
    @GET("search?term=in+utero&mediaType=music&limit=20")
    fun getSong(): Call<SongEntry>
}