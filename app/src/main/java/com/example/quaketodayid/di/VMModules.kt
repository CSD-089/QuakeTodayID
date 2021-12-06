package com.example.quaketodayid.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quaketodayid.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class VMModules {
    @Binds
    @IntoMap
    @VMKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @VMKey(ShowViewModel::class)
//    abstract fun bindTVShowViewModel(viewModel: ShowViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @VMKey(DashboardViewModel::class)
//    abstract fun bindDashboardViewModel(viewModel: DashboardViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @VMKey(FavouriteViewModel::class)
//    abstract fun bindFavouriteViewModel(tvShowDetailViewModel: FavouriteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: VMFactory): ViewModelProvider.Factory

}