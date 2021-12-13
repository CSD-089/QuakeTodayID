package com.example.quaketodayid.utils

import com.mapbox.mapboxsdk.geometry.LatLng

object Convert {
    fun stringToLatLng(coordinate: String): LatLng {
        val latitude = coordinate.substringBefore(",")
        val longitude = coordinate.substringAfter(",")

        return LatLng(latitude.toDouble(), longitude.toDouble())
    }
}