package com.example.quaketodayid.ui.main.dashboard.terbaru;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/quaketodayid/ui/main/dashboard/terbaru/TerbaruViewModel;", "Landroidx/lifecycle/ViewModel;", "networkRepository", "Lcom/example/quaketodayid/data/network/NetworkRepository;", "(Lcom/example/quaketodayid/data/network/NetworkRepository;)V", "_reloadTrigger", "Landroidx/lifecycle/MutableLiveData;", "", "getAutoGempa", "Landroidx/lifecycle/LiveData;", "Lcom/example/quaketodayid/data/network/ApiResponse;", "Lcom/example/quaketodayid/data/model/AutoGempaResponse;", "getGetAutoGempa", "()Landroidx/lifecycle/LiveData;", "reload", "", "app_debug"})
public final class TerbaruViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.quaketodayid.data.network.NetworkRepository networkRepository = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _reloadTrigger = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.AutoGempaResponse>> getAutoGempa = null;
    
    @javax.inject.Inject()
    public TerbaruViewModel(@org.jetbrains.annotations.NotNull()
    com.example.quaketodayid.data.network.NetworkRepository networkRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quaketodayid.data.network.ApiResponse<com.example.quaketodayid.data.model.AutoGempaResponse>> getGetAutoGempa() {
        return null;
    }
    
    public final void reload() {
    }
}