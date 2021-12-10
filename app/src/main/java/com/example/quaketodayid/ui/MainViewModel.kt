package com.example.quaketodayid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.NewestGempaResponse
import com.example.quaketodayid.data.network.ApiResponse
import com.example.quaketodayid.data.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModel() {

    fun getAutoGempa(): LiveData<ApiResponse<AutoGempaResponse>> =
        networkRepository.getAutoGempa()

    fun getGempaTerbaru(): LiveData<ApiResponse<NewestGempaResponse>> =
        networkRepository.getGempaTerbaru()

    fun getGempaDirasakan(): LiveData<ApiResponse<GempaDirasakan>> =
        networkRepository.getGempaDirasakan()


}