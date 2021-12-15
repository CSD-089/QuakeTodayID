package com.example.quaketodayid.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quaketodayid.data.model.AutoGempaResponse
import com.example.quaketodayid.data.model.GempaDirasakan
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.data.model.NewestGempaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepository @Inject constructor(private val service: ApiService) {

    fun getAutoGempa(): LiveData<ApiResponse<AutoGempaResponse>> {
        val result = MutableLiveData<ApiResponse<AutoGempaResponse>>()
        val api = service.getAutoGempa()
        api.enqueue(object : Callback<AutoGempaResponse> {
            override fun onResponse(
                call: Call<AutoGempaResponse>,
                response: Response<AutoGempaResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        result.value = ApiResponse.success(body)
                    } else {
                        result.value =
                            ApiResponse.error("No response from the server", AutoGempaResponse())
                    }
                } else {
                    result.value = ApiResponse.error(
                        "An Error reported [${response.code()}]. Please try again later.",
                        AutoGempaResponse()
                    )
                }
            }

            override fun onFailure(call: Call<AutoGempaResponse>, t: Throwable) {
                result.value = ApiResponse.error(
                    "An Error reported [UNKNOWN]. We will fix it immediately.",
                    AutoGempaResponse()
                )
            }
        })
        return result
    }

    fun getAutoGempaSync(): ApiResponse<GempaItem> {
        val result: ApiResponse<GempaItem>
        val call = service.getAutoGempaSync().execute()
        result = if (call.isSuccessful) {
            ApiResponse.success(call.body()?.infogempa?.gempa!!)
        } else {
            ApiResponse.error(call.message().toString(), GempaItem())
        }
        return result
    }

    fun getGempaTerbaru(): LiveData<ApiResponse<NewestGempaResponse>> {
        val result = MutableLiveData<ApiResponse<NewestGempaResponse>>()
        val api = service.getNewestGempa()
        api.enqueue(object : Callback<NewestGempaResponse> {
            override fun onResponse(
                call: Call<NewestGempaResponse>,
                response: Response<NewestGempaResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        result.value = ApiResponse.success(body)
                    } else {
                        result.value =
                            ApiResponse.error("No response from the server", NewestGempaResponse())
                    }
                } else {
                    result.value = ApiResponse.error(
                        "An Error reported [${response.code()}]. Please try again later.",
                        NewestGempaResponse()
                    )
                }
            }

            override fun onFailure(call: Call<NewestGempaResponse>, t: Throwable) {
                result.value = ApiResponse.error(
                    "An Error reported [UNKNOWN]. We will fix it immediately.",
                    NewestGempaResponse()
                )
            }
        })
        return result
    }

    fun getGempaDirasakan(): LiveData<ApiResponse<GempaDirasakan>> {
        val result = MutableLiveData<ApiResponse<GempaDirasakan>>()
        val api = service.getGempaDirasakan()
        api.enqueue(object : Callback<GempaDirasakan> {
            override fun onResponse(
                call: Call<GempaDirasakan>,
                response: Response<GempaDirasakan>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        result.value = ApiResponse.success(body)
                    } else {
                        result.value =
                            ApiResponse.error("No response from the server", GempaDirasakan())
                    }
                } else {
                    result.value = ApiResponse.error(
                        "An Error reported [${response.code()}]. Please try again later.",
                        GempaDirasakan()
                    )
                }
            }

            override fun onFailure(call: Call<GempaDirasakan>, t: Throwable) {
                result.value = ApiResponse.error(
                    "An Error reported [UNKNOWN]. We will fix it immediately.",
                    GempaDirasakan()
                )
            }
        })
        return result
    }
}