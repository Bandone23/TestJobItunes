package com.example.mytestitunesnew.ui.adapter.holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.databinding.ItemSongBinding
import com.example.mytestitunesnew.domain.model.SongList
import com.example.mytestitunesnew.util.getImgPicasso


class SongHolder (
    private val binding: ItemSongBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(song: SongList,clickListener: (SongList, Int) -> Unit) {
        val context = itemView.context
        binding.song = song

        binding.cardSong.setOnClickListener{ clickListener(song,R.id.card_song)}
        getImgPicasso(song.artworkUrl60,binding.imageView)
        binding.executePendingBindings()
    }


}