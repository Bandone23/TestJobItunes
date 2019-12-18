package com.example.mytestitunesnew.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.databinding.ItemSongBinding
import com.example.mytestitunesnew.domain.model.SongList
import com.example.mytestitunesnew.ui.adapter.holder.SongHolder

class SongAdapter(
    private var song: MutableList<SongList>,
    private val clickListener: (SongList, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemBinding: ItemSongBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_song,
                parent,
                false
            )
        return SongHolder(itemBinding)
    }

    override fun getItemCount(): Int {
       return song.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = song[position]
        holder as SongHolder
        holder.bindEvent(item,clickListener)
    }

    fun setData(songList: List<SongList>) {
        if (song.isNullOrEmpty()) {
            song = songList.toMutableList()
        }else {
            song.clear()
            song.addAll(song.size,songList)
        }

        notifyDataSetChanged()
    }

}