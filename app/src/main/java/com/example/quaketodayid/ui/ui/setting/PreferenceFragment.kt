package com.example.quaketodayid.ui.ui.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.example.quaketodayid.R

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
        Preference.OnPreferenceChangeListener { preference, newValue ->
            // TODO: Not yet implemented
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