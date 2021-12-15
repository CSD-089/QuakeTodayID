package com.example.quaketodayid.data.network

import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.NewestGempaResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("autogempa.json")
    fun getAutoGempa(): Call<AutoGempaResponse>

    @GET("autogempa.json")
    fun getAutoGempaSync(): Call<AutoGempaResponse>

    @GET("gempaterkini.json")
    fun getNewestGempa(): Call<NewestGempaResponse>

    @GET("gempadirasakan.json")
    fun getGempaDirasakan(): Call<GempaDirasakan>
}