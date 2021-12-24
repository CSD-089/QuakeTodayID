package com.example.quaketodayid.utils

import androidx.lifecycle.LiveData
import com.example.quaketodayid.data.model.*

object DummyData {
    private val data = listOf<GempaItem>(
        GempaItem(
            "3.6",
            "malang",
            "null",
            "10km",
            "10 pagi",
            "33282",
            "berpotensi banget",
            "10 desember",
            "312793",
            "3.9",
            "9021213",
            "12-10-2020"
        ),
        GempaItem(
            "3.7",
            "bandung",
            "null",
            "110km",
            "9 pagi",
            "33282",
            "berpotensi banget",
            "10 desember",
            "312793",
            "3.9",
            "9021213",
            "12-10-2020"
        )
    )

    fun getDummyData(): List<GempaItem> {
        return data

    }
    fun getNewestGempa():NewestGempaResponse{
        return NewestGempaResponse(Infogempa(getDummyData()))
    }
    fun getGempaDirasakan():GempaDirasakan{
        return GempaDirasakan(Infogempa(getDummyData()))
    }

    fun getAutoGempa(): AutoGempaResponse {
        return AutoGempaResponse(AutoInfoGempa(data[0]))
    }
}