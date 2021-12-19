package com.example.quaketodayid.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/quaketodayid/data/network/ApiService;", "", "getAutoGempa", "Lretrofit2/Call;", "Lcom/example/quaketodayid/data/model/AutoGempaResponse;", "getAutoGempaSync", "getGempaDirasakan", "Lcom/example/quaketodayid/data/model/GempaDirasakan;", "getNewestGempa", "Lcom/example/quaketodayid/data/model/NewestGempaResponse;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "autogempa.json")
    public abstract retrofit2.Call<com.example.quaketodayid.data.model.AutoGempaResponse> getAutoGempa();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "autogempa.json")
    public abstract retrofit2.Call<com.example.quaketodayid.data.model.AutoGempaResponse> getAutoGempaSync();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "gempaterkini.json")
    public abstract retrofit2.Call<com.example.quaketodayid.data.model.NewestGempaResponse> getNewestGempa();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "gempadirasakan.json")
    public abstract retrofit2.Call<com.example.quaketodayid.data.model.GempaDirasakan> getGempaDirasakan();
}