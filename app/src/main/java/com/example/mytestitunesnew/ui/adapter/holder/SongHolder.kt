package com.example.mytestitunesnew.ui.adapter.holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.databinding.ItemSongBinding
import com.example.mytestitunesnew.domain.model.SongList
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class SongHolder (
    private val binding: ItemSongBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(song: SongList,clickListener: (SongList, Int) -> Unit) {
        val context = itemView.context
        binding.song = song
/*
        binding.cardParking.setOnClickListener { clickListener (parking, R.id.card_parking)}
        binding.imgTimer.setOnClickListener { clickListener(parking,R.id.img_timer) }*/


        getImgPicasso(song.artworkUrl60,binding.imageView)


        binding.executePendingBindings()
    }



    fun getImgPicasso(picture: String, view: ImageView?) {
        if (picture.isNotEmpty()) {
            Picasso.get()
                .load(picture)
                .error(R.drawable.ic_cd)
                .into(view)
        } else {
            Picasso.get()
                .load(R.drawable.ic_cd)
                .error(R.drawable.ic_cd)
                .into(view)
        }
    }
}