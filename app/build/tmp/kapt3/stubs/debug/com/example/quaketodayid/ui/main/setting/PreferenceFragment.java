package com.example.quaketodayid.ui.main.setting;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/quaketodayid/ui/main/setting/PreferenceFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "()V", "prefNotification", "Landroidx/preference/SwitchPreference;", "prefReset", "Landroidx/preference/Preference;", "prefTheme", "Landroidx/preference/ListPreference;", "initComponents", "", "onCreatePreferences", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onNotificationPreferenceChange", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "onPreferenceResetClick", "Landroidx/preference/Preference$OnPreferenceClickListener;", "onThemePreferenceChange", "updateTheme", "", "mode", "", "app_debug"})
public final class PreferenceFragment extends androidx.preference.PreferenceFragmentCompat {
    private androidx.preference.SwitchPreference prefNotification;
    private androidx.preference.ListPreference prefTheme;
    private androidx.preference.Preference prefReset;
    
    public PreferenceFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreatePreferences(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState, @org.jetbrains.annotations.Nullable()
    java.lang.String rootKey) {
    }
    
    private final void initComponents() {
    }
    
    private final androidx.preference.Preference.OnPreferenceChangeListener onNotificationPreferenceChange() {
        return null;
    }
    
    private final androidx.preference.Preference.OnPreferenceChangeListener onThemePreferenceChange() {
        return null;
    }
    
    private final androidx.preference.Preference.OnPreferenceClickListener onPreferenceResetClick() {
        return null;
    }
    
    private final boolean updateTheme(int mode) {
        return false;
    }
}