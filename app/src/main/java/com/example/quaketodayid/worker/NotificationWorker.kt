package com.example.quaketodayid.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.data.network.ApiService
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val apiService: ApiService,
    private val notificationPreference: NotificationPreference
) : Worker(context, params) {

    override fun doWork(): Result {
        val api = apiService.getAutoGempaSync()
        return Result.success()
    }

    private fun showNotification(item: GempaItem) {

    }

}