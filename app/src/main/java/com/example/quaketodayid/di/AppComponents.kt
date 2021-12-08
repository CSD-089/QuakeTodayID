package com.example.quaketodayid.di

import android.content.Context
import com.example.quaketodayid.ui.ui.dashboard.DashboardFragment
import com.example.quaketodayid.ui.ui.rating.RatingFragment
import com.example.quaketodayid.ui.ui.setting.SettingFragment
import com.example.quaketodayid.ui.ui.share.ShareFragment
import com.example.quaketodayid.ui.ui.terbaru.TerbaruFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [VMModules::class, AppModule::class])
interface AppComponents {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponents
    }

    fun inject(fragment: SettingFragment)
    fun inject(fragment: RatingFragment)
    fun inject(activity: ShareFragment)
    fun inject(fragment: DashboardFragment)
    fun inject(fragment: TerbaruFragment)
//    fun inject(activity: ShowDetailActivity)
//    fun inject(fragment: FavouriteMovieFragment)
//    fun inject(fragment: FavouriteTvShowFragment)

}