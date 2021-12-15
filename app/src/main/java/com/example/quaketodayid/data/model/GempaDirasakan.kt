package com.example.quaketodayid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GempaDirasakan(

    @field:SerializedName("Infogempa")
    val infogempa: Infogempa? = null
) : Parcelable

