package com.example.quaketodayid.data.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.quaketodayid.LiveDataTestUtil
import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.NewestGempaResponse
import com.example.quaketodayid.utils.DummyData
import okhttp3.internal.tls.OkHostnameVerifier.verify
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*

class NetworkRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val networkRepository = mock(NetworkRepository::class.java)
    private val listItem = DummyData.getDummyData()
    private val item = listItem[0]
    private val autoGempa = DummyData.getAutoGempa()
    private val newestGempa = DummyData.getNewestGempa()
    private val gempaDirasakan = DummyData.getGempaDirasakan()

    @Test
    fun getAutoGempa() {
        val dummyData = MutableLiveData<ApiResponse<AutoGempaResponse>>()
        dummyData.value = ApiResponse.success(autoGempa)

        `when`(networkRepository.getAutoGempa()).thenReturn(dummyData)
        val data = LiveDataTestUtil.getValue(networkRepository.getAutoGempa())

        verify(networkRepository).getAutoGempa()
        assertNotNull(data)
        assertEquals(autoGempa.infogempa,data.body?.infogempa)
    }

    @Test
    fun getAutoGempaSync() {
        val dummyData =  ApiResponse.success(item)

        `when`(networkRepository.getAutoGempaSync()).thenReturn(dummyData)
        val data = networkRepository.getAutoGempaSync()

        verify(networkRepository).getAutoGempaSync()
        assertNotNull(data)
        assertEquals(autoGempa.infogempa?.gempa,data.body)
    }

    @Test
    fun getGempaTerbaru() {
        val dummyData = MutableLiveData<ApiResponse<NewestGempaResponse>>()
        dummyData.value = ApiResponse.success(newestGempa)

        `when`(networkRepository.getGempaTerbaru()).thenReturn(dummyData)
        val data = LiveDataTestUtil.getValue(networkRepository.getGempaTerbaru())

        verify(networkRepository).getGempaTerbaru()
        assertNotNull(data)
        assertEquals(newestGempa.infogempa,data.body?.infogempa)
    }

    @Test
    fun getGempaDirasakan() {
        val dummyData = MutableLiveData<ApiResponse<GempaDirasakan>>()
        dummyData.value = ApiResponse.success(gempaDirasakan)

        `when`(networkRepository.getGempaDirasakan()).thenReturn(dummyData)
        val data = LiveDataTestUtil.getValue(networkRepository.getGempaDirasakan())

        verify(networkRepository).getGempaDirasakan()
        assertNotNull(data)
        assertEquals(newestGempa.infogempa,data.body?.infogempa)
    }
}