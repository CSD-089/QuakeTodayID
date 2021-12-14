package com.example.quaketodayid.utils

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.ortiz.touchview.TouchImageView

fun TouchImageView.loadUrl(url: String) {
    Glide.with(this).clear(this)
    Glide.with(this).load(url).into(this)
}

fun CardView.toGreen(){
    this.setCardBackgroundColor(Color.GREEN)
}

fun CardView.toYellow(){
    this.setCardBackgroundColor(Color.YELLOW)
}

fun CardView.toRed(){
    this.setCardBackgroundColor(Color.RED)
}
