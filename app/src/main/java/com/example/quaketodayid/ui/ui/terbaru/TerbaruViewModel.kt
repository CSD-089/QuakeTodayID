package com.example.quaketodayid.ui.ui.terbaru

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.network.ApiResponse
import com.example.quaketodayid.data.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TerbaruViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _reloadTrigger = MutableLiveData<Boolean>()

    fun getAutoGempa(): LiveData<ApiResponse<AutoGempaResponse>> =
        Transformations.switchMap(_reloadTrigger) {
            networkRepository.getAutoGempa()
        }

    fun reload() {
        _reloadTrigger.value = true
    }
}