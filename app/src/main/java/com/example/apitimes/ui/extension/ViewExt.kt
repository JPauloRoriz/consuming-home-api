package com.example.apitimes.ui.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat

fun ImageView.loadFromUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}