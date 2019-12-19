package com.example.mytestitunesnew.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.databinding.FragmentSongBinding
import com.example.mytestitunesnew.databinding.FragmentSongDetailBinding
import com.example.mytestitunesnew.util.getImgPicasso
import kotlinx.android.synthetic.main.fragment_song_detail.*


class SongDetailFragment : DialogFragment() {

    lateinit var binding: FragmentSongDetailBinding

    companion object {
        fun newInstance(url:String,albumName:String,trackNumber:Int): SongDetailFragment {
            val fragment = SongDetailFragment()
            val args =Bundle()
            args.putString(URL_PHOTO, url)
            args.putString(ALBUM_NAME,albumName)
            args.putInt(TRACK_NUMBER,trackNumber)
            fragment.arguments =args


            return  fragment
        }

       private const val URL_PHOTO = "url"
        private const val ALBUM_NAME ="albumName"
        private const val TRACK_NUMBER ="trackNumber"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val style = STYLE_NO_FRAME
        val theme = R.style.FullScreenDialogStyle
        setStyle(style, theme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_song_detail, container, false
        binding = FragmentSongDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getImgPicasso(arguments!!.getString(URL_PHOTO)!!,binding.imgSong)
        binding.trackNumber.text = arguments!!.getInt(TRACK_NUMBER).toString()
        binding.lblAlbum.text = arguments!!.getString(ALBUM_NAME)!!
        img_close.setOnClickListener { dismiss() }
    }

}
