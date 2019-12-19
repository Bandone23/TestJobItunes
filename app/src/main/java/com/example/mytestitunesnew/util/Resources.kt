package com.example.mytestitunesnew.util

import android.widget.ImageView
import com.example.mytestitunesnew.R
import com.squareup.picasso.Picasso

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