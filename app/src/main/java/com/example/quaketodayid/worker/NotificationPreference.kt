package com.example.quaketodayid.worker

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationPreference @Inject constructor(private val application: Application) {

    private val dirasakan: String = application.getString(R.string.pref_notify_last_dirasakan)
    private val wilayah: String = application.getString(R.string.pref_notify_last_wilayah)
    private val kedalaman: String = application.getString(R.string.pref_notify_last_kedalaman)
    private val jam: String = application.getString(R.string.pref_notify_last_time)
    private val coordinates: String = application.getString(R.string.pref_notify_last_coordinates)
    private val potensi: String = application.getString(R.string.pref_notify_last_potensi)
    private val tanggal: String = application.getString(R.string.pref_notify_last_date)
    private val bujur: String = application.getString(R.string.pref_notify_last_bujur)
    private val magnitude: String = application.getString(R.string.pref_notify_last_magnitude)
    private val lintang: String = application.getString(R.string.pref_notify_last_lintang)
    private val dateTime: String = application.getString(R.string.pref_notify_last_datetime)
    private val shakemap: String = application.getString(R.string.pref_notify_last_shakemap)

    private lateinit var preference: SharedPreferences

    fun initComponents(): NotificationPreference {
        preference = application.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return this
    }

    fun setLastInfo(item: GempaItem) {
        preference.edit().apply {
            putString(tanggal, item.tanggal)
            putString(jam, item.jam)
            putString(dateTime, item.dateTime)
            putString(kedalaman, item.kedalaman)
            putString(lintang, item.lintang)
            putString(bujur, item.bujur)
            putString(wilayah, item.wilayah)
            putString(coordinates, item.coordinates)
            putString(magnitude, item.magnitude)
            putString(potensi, item.potensi)
            putString(shakemap, item.shakemap)
            apply()
        }
    }

    fun getLastInfo(): GempaItem =
        GempaItem(
            tanggal = preference.getString(tanggal, "01 Jan 1970"),
            jam = preference.getString(jam, "23:59:59 WIX"),
            dateTime = preference.getString(dateTime, "01 Jan 1970T23:59:59+00.00"),
            coordinates = preference.getString(coordinates, "0.0,0.0"),
            magnitude = preference.getString(magnitude, "0.0"),
            bujur = preference.getString(bujur, "0.0"),
            lintang = preference.getString(lintang, "0.0"),
            dirasakan = preference.getString(dirasakan, "Tidak ada"),
            kedalaman = preference.getString(kedalaman, "0 km"),
            potensi = preference.getString(potensi, "Tidak berpotensi tsunami"),
            shakemap = preference.getString(shakemap, "0.mmi.jpg"),
            wilayah = preference.getString(wilayah, "0 km BaratDaya LEMBAH-UNK")
        )

    companion object {
        private const val PREFERENCE_NAME = "last_quake_preferences"
    }
}