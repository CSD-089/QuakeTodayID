package com.example.quaketodayid.worker;

import java.lang.System;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/quaketodayid/worker/NotificationWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "networkRepository", "Lcom/example/quaketodayid/data/network/NetworkRepository;", "notificationPreference", "Lcom/example/quaketodayid/worker/NotificationPreference;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/example/quaketodayid/data/network/NetworkRepository;Lcom/example/quaketodayid/worker/NotificationPreference;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "getPendingIntent", "Landroid/app/PendingIntent;", "gempaItem", "Lcom/example/quaketodayid/data/model/GempaItem;", "showNotification", "", "item", "Companion", "app_debug"})
public final class NotificationWorker extends androidx.work.Worker {
    private final com.example.quaketodayid.data.network.NetworkRepository networkRepository = null;
    private final com.example.quaketodayid.worker.NotificationPreference notificationPreference = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.quaketodayid.worker.NotificationWorker.Companion Companion = null;
    private static final int NOTIFICATION_ID = 120;
    private static final java.lang.String CHANNEL_ID = "NOTIFICATION_QUAKE_INFO";
    private static final java.lang.String CHANNEL_NAME = "Earthquake Info";
    
    @dagger.assisted.AssistedInject()
    public NotificationWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters params, @org.jetbrains.annotations.NotNull()
    com.example.quaketodayid.data.network.NetworkRepository networkRepository, @org.jetbrains.annotations.NotNull()
    com.example.quaketodayid.worker.NotificationPreference notificationPreference) {
        super(null, null);
    }
    
    private final android.app.PendingIntent getPendingIntent(com.example.quaketodayid.data.model.GempaItem gempaItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.work.ListenableWorker.Result doWork() {
        return null;
    }
    
    private final void showNotification(com.example.quaketodayid.data.model.GempaItem item) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/quaketodayid/worker/NotificationWorker$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "NOTIFICATION_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}