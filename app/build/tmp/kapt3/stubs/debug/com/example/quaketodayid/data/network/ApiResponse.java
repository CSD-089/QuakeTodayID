package com.example.quaketodayid.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0010B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/example/quaketodayid/data/network/ApiResponse;", "T", "", "status", "Lcom/example/quaketodayid/data/network/StatusResponse;", "body", "message", "", "(Lcom/example/quaketodayid/data/network/StatusResponse;Ljava/lang/Object;Ljava/lang/String;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessage", "()Ljava/lang/String;", "getStatus", "()Lcom/example/quaketodayid/data/network/StatusResponse;", "Companion", "app_debug"})
public final class ApiResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final com.example.quaketodayid.data.network.StatusResponse status = null;
    @org.jetbrains.annotations.Nullable()
    private final T body = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.quaketodayid.data.network.ApiResponse.Companion Companion = null;
    
    public ApiResponse(@org.jetbrains.annotations.Nullable()
    com.example.quaketodayid.data.network.StatusResponse status, @org.jetbrains.annotations.Nullable()
    T body, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.quaketodayid.data.network.StatusResponse getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getBody() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005\u00a2\u0006\u0002\u0010\tJ)\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005\u00a2\u0006\u0002\u0010\tJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\b\u001a\u0004\u0018\u0001H\u0005\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/quaketodayid/data/network/ApiResponse$Companion;", "", "()V", "error", "Lcom/example/quaketodayid/data/network/ApiResponse;", "T", "message", "", "body", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/example/quaketodayid/data/network/ApiResponse;", "loading", "success", "(Ljava/lang/Object;)Lcom/example/quaketodayid/data/network/ApiResponse;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.quaketodayid.data.network.ApiResponse<T> success(@org.jetbrains.annotations.Nullable()
        T body) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.quaketodayid.data.network.ApiResponse<T> loading(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.Nullable()
        T body) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.example.quaketodayid.data.network.ApiResponse<T> error(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.Nullable()
        T body) {
            return null;
        }
    }
}