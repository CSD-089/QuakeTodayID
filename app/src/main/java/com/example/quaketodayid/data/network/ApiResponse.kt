package com.example.quaketodayid.data.network

import androidx.annotation.Nullable

class ApiResponse<T>(
    val status: StatusResponse, @param:Nullable @field:Nullable
    val body: T, @param:Nullable @field:Nullable
    val message: String?
) {
    companion object {
        fun <T> success(@Nullable body: T): ApiResponse<T> {
            return ApiResponse(StatusResponse.SUCCESS, body, null)
        }

        fun <T> loading(message: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(StatusResponse.EMPTY, body, message)
        }

        fun <T> error(message: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(StatusResponse.ERROR, body, message)
        }
    }

}

enum class StatusResponse {
    SUCCESS,
    EMPTY,
    ERROR
}