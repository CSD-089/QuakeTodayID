package com.example.quaketodayid.ui.main.dashboard.terkini

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.quaketodayid.data.model.NewestGempaResponse
import com.example.quaketodayid.data.network.ApiResponse
import com.example.quaketodayid.data.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TerkiniViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _reloadTrigger = MutableLiveData<Boolean>()

    init {
        reload()
    }

    val getGempaTerbaru: LiveData<ApiResponse<NewestGempaResponse>> =
        Transformations.switchMap(_reloadTrigger) {
            networkRepository.getGempaTerbaru()
        }

    fun reload() {
        _reloadTrigger.value = true
    }
}