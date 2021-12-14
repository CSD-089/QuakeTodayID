package com.example.quaketodayid.ui.main.dashboard.dirasakan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.network.ApiResponse
import com.example.quaketodayid.data.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DirasakanViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _reloadTrigger = MutableLiveData<Boolean>()

    fun getGempaDirasakan(): LiveData<ApiResponse<GempaDirasakan>> =
        networkRepository.getGempaDirasakan()

    fun reload() {
        _reloadTrigger.value = true
    }
}