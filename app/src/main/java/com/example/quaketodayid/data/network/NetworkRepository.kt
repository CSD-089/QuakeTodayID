package com.example.quaketodayid.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.NewestGempaResponse
import com.google.android.gms.common.api.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepository @Inject constructor(private val service: ApiService) {

    fun getAutoGempa(): LiveData<ApiResponse<AutoGempaResponse>> {
        val result = MutableLiveData<ApiResponse<AutoGempaResponse>>()
        GlobalScope.launch {
            val postRequest = service.getAutoGempa()
            val postResponse = postRequest.await()
            result.postValue(ApiResponse.success(postResponse))
        }
        return result
    }

    fun getGempaTerbaru(): LiveData<ApiResponse<NewestGempaResponse>> {
        val result = MutableLiveData<ApiResponse<NewestGempaResponse>>()
        GlobalScope.launch {
            val postRequest = service.getNewestGempa()
            val postResponse = postRequest.await()
            result.postValue(ApiResponse.success(postResponse))
        }
        return result
    }

    fun getGempaDirasakan(): LiveData<ApiResponse<GempaDirasakan>> {
        val result = MutableLiveData<ApiResponse<GempaDirasakan>>()
        GlobalScope.launch {
            val postRequest = service.getGempaDirasakan()
            val postResponse = postRequest.await()
            result.postValue(ApiResponse.success(postResponse))
        }
        return result
    }
}