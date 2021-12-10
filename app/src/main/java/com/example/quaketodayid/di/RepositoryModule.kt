package com.example.quaketodayid.di

import com.example.quaketodayid.data.network.ApiService
import com.example.quaketodayid.data.network.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideNetworkRepository(apiService: ApiService): NetworkRepository =
        NetworkRepository(apiService)

}