package com.example.quaketodayid.worker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/quaketodayid/worker/NotificationPreference;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bujur", "", "coordinates", "dateTime", "dirasakan", "jam", "kedalaman", "lintang", "magnitude", "potensi", "preference", "Landroid/content/SharedPreferences;", "shakemap", "tanggal", "wilayah", "getLastInfo", "Lcom/example/quaketodayid/data/model/GempaItem;", "initComponents", "setLastInfo", "", "item", "Companion", "app_debug"})
@javax.inject.Singleton()
public final class NotificationPreference {
    private final android.app.Application application = null;
    private final java.lang.String dirasakan = null;
    private final java.lang.String wilayah = null;
    private final java.lang.String kedalaman = null;
    private final java.lang.String jam = null;
    private final java.lang.String coordinates = null;
    private final java.lang.String potensi = null;
    private final java.lang.String tanggal = null;
    private final java.lang.String bujur = null;
    private final java.lang.String magnitude = null;
    private final java.lang.String lintang = null;
    private final java.lang.String dateTime = null;
    private final java.lang.String shakemap = null;
    private android.content.SharedPreferences preference;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.quaketodayid.worker.NotificationPreference.Companion Companion = null;
    private static final java.lang.String PREFERENCE_NAME = "last_quake_preferences";
    
    @javax.inject.Inject()
    public NotificationPreference(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.quaketodayid.worker.NotificationPreference initComponents() {
        return null;
    }
    
    public final void setLastInfo(@org.jetbrains.annotations.NotNull()
    com.example.quaketodayid.data.model.GempaItem item) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.quaketodayid.data.model.GempaItem getLastInfo() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/quaketodayid/worker/NotificationPreference$Companion;", "", "()V", "PREFERENCE_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}