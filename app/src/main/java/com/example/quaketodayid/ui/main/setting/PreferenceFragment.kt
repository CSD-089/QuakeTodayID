package com.example.quaketodayid.ui.main.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.quaketodayid.R
import com.example.quaketodayid.worker.NotificationWorker
import java.util.concurrent.TimeUnit

class PreferenceFragment : PreferenceFragmentCompat() {

    private lateinit var prefNotification: SwitchPreference
    private lateinit var prefTheme: ListPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.root_preferences)
        initComponents()
    }

    private fun initComponents() {
        prefNotification = findPreference<SwitchPreference>(getString(R.string.pref_key_notification))
                as SwitchPreference
        prefTheme = findPreference<ListPreference>(getString(R.string.pref_key_theme))
                as ListPreference

        prefNotification.onPreferenceChangeListener = onNotificationPreferenceChange()
        prefTheme.onPreferenceChangeListener = onThemePreferenceChange()
    }

    private fun onNotificationPreferenceChange(): Preference.OnPreferenceChangeListener =
        Preference.OnPreferenceChangeListener { _, newValue ->
            val workManager = WorkManager.getInstance(requireContext())
            val periodicWorkRequest = PeriodicWorkRequest.Builder(
                NotificationWorker::class.java,
                3,
                TimeUnit.MINUTES
            ).build()

            if (newValue.equals(true)) {
                workManager.enqueue(periodicWorkRequest)
            } else {
                workManager.cancelAllWork()
            }
            true
        }

    private fun onThemePreferenceChange(): Preference.OnPreferenceChangeListener =
        Preference.OnPreferenceChangeListener { _, newValue ->
            when {
                newValue.equals(getString(R.string.pref_theme_entry_auto)) -> {
                    updateTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                }
                newValue.equals(getString(R.string.pref_theme_entry_dark)) -> {
                    updateTheme(AppCompatDelegate.MODE_NIGHT_YES)
                }
                newValue.equals(getString(R.string.pref_theme_entry_light)) -> {
                    updateTheme(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
            true
        }

    private fun updateTheme(mode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(mode)
        requireActivity().recreate()
        return true
    }
}