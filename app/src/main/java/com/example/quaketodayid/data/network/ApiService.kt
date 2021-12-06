package com.example.quaketodayid.data.network

import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.NewestGempaResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("autogempa.json")
    fun getAutoGempa(): Deferred<AutoGempaResponse>

    @GET("gempaterkini.json")
    fun getNewestGempa(): Deferred<NewestGempaResponse>

    @GET("gempadirasakan.json")
    fun getGempaDirasakan(): Deferred<GempaDirasakan>
}