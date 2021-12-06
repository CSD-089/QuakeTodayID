package com.example.quaketodayid

import android.app.Application
import com.example.quaketodayid.di.AppComponents
import com.example.quaketodayid.di.DaggerAppComponents

class BaseApp :Application() {
    val appComponents : AppComponents by lazy {
        DaggerAppComponents.factory().create(applicationContext)
    }
}