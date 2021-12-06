package com.example.quaketodayid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AutoGempaResponse(

    @field:SerializedName("Infogempa")
    val infogempa: AutoInfoGempa? = null
) : Parcelable

