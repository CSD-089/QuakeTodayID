package com.example.quaketodayid.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.data.network.NetworkRepository
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.ui.detail.DetailGempaActivity
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
    class NotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val networkRepository: NetworkRepository,
    private val notificationPreference: NotificationPreference
) : Worker(context, params) {

    private fun getPendingIntent(gempaItem: GempaItem): PendingIntent? {
        val intent = Intent(applicationContext, DetailGempaActivity::class.java).apply {
            putExtra("data", gempaItem)
        }
        return TaskStackBuilder.create(applicationContext).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    override fun doWork(): Result {
        val api = networkRepository.getAutoGempaSync()
        val local = notificationPreference.initComponents().getLastInfo()

        when (api.status) {
            StatusResponse.SUCCESS -> {
                if (api.body.tanggal != local.tanggal && local.tanggal != null && api.body.tanggal != null) {
                    showNotification(api.body)
                    notificationPreference.initComponents().setLastInfo(api.body)
                }
                return Result.success()
            }
            StatusResponse.ERROR -> {
                Log.e("NotificationWorker", api.message.toString())
                return Result.failure()
            }
            StatusResponse.EMPTY -> {
                Log.d("NotificationWorker", "Empty data received")
                return Result.success()
            }
        }
    }

    private fun showNotification(item: GempaItem) {
        val intent = getPendingIntent(item)
        val notificationStyle = NotificationCompat.BigTextStyle()
            .bigText(
                applicationContext.getString(
                    R.string.notify_content,
                    item.magnitude,
                    item.tanggal,
                    item.jam,
                    item.kedalaman,
                    item.wilayah,
                    item.potensi
                )
            )
            .setBigContentTitle(
                applicationContext.getString(R.string.notify_title, item.tanggal)
            )
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_terbaru)
            .setContentTitle(applicationContext.getString(R.string.notify_title, item.tanggal))
            .setContentText(
                applicationContext.getString(
                    R.string.notify_content,
                    item.magnitude,
                    item.tanggal,
                    item.jam,
                    item.kedalaman,
                    item.wilayah,
                    item.potensi
                )
            )
            .setContentIntent(intent)
            .setStyle(notificationStyle)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
            )
            notification.setChannelId(CHANNEL_ID)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(NOTIFICATION_ID, notification.build())
    }

    companion object {
        private const val NOTIFICATION_ID = 120
        private const val CHANNEL_ID = "NOTIFICATION_QUAKE_INFO"
        private const val CHANNEL_NAME = "Earthquake Info"
    }

}