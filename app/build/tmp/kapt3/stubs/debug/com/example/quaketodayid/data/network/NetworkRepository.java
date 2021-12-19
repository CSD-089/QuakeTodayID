package com.example.quaketodayid.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006J\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/quaketodayid/data/network/NetworkRepository;", "", "service", "Lcom/example/quaketodayid/data/network/ApiService;", "(Lcom/example/quaketodayid/data/network/ApiService;)V", "getAutoGempa", "Landroidx/lifecycle/LiveData;", "Lcom/example/quaketodayid/data/network/ApiResponse;", "Lcom/example/quaketodayid/data/model/AutoGempaResponse;", "getAutoGempaSync", "Lcom/example/quaketodayid/data/model/GempaItem;", "getGempaDirasakan", "Lcom/example/quaketodayid/data/model/GempaDirasakan;", "getGempaTerbaru", "Lcom/example/quaketodayid/data/model/NewestGempaResponse;", "app_debug"})
@javax.inject.Singleton()
public final class NetworkRepository {
    private final com.example.quaketodayid.data.network.ApiService service = null;
    
    @javax.inject.Inject()
    public NetworkRepository(@org.jetbrains.annotations.NotNull()
    com.example.quaketodayid.data.network.ApiService service) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.AutoGempaResponse>> getAutoGempa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.GempaItem> getAutoGempaSync() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.NewestGempaResponse>> getGempaTerbaru() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.GempaDirasakan>> getGempaDirasakan() {
        return null;
    }
}