package com.example.quaketodayid.ui.detail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.databinding.ActivityDetailGempaBinding
import com.example.quaketodayid.utils.Convert
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import com.mapbox.mapboxsdk.style.layers.Property
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailGempaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGempaBinding

    private lateinit var mapboxMap: MapboxMap
    private lateinit var symbolManager: SymbolManager

    private lateinit var data: GempaItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGempaBinding.inflate(layoutInflater)
        binding.mapView.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        data = intent.getParcelableExtra("data")!!

        binding.apply {
            mapView.getMapAsync { mapboxMap ->
                this@DetailGempaActivity.mapboxMap = mapboxMap
                mapboxMap.setStyle(getPreferenceMapStyle()) { style ->
                    symbolManager = SymbolManager(mapView, mapboxMap, style)
                    symbolManager.iconAllowOverlap = true
                    style.addImage(
                        ICON_ID,
                        BitmapFactory.decodeResource(
                            resources,
                            R.drawable.mapbox_marker_icon_default
                        )
                    )
                    setQuakeLocation(
                        Convert.stringToLatLng(data.coordinates ?: "0.0,0.0"),
                        "${data.lintang}, ${data.bujur}"
                    )
                }
            }
            with(this.contentDetails) {
                val magnitude = "${data.magnitude}SR"
                this.tvDetailsMagnitude.text = magnitude

                val dateTime = "${data.tanggal} ${data.jam}"
                this.tvDetailsDateTime.text = dateTime

                this.tvDetailsLocation.text = data.wilayah

                val coordinate = "${data.lintang}, ${data.bujur}"
                this.tvDetailsCoordinate.text = coordinate

                this.tvDetailsDepth.text = data.kedalaman

                if (data.dirasakan != null) {
                    if (data.dirasakan != "-") {
                        this.tvDetailsFeel.text = data.dirasakan
                    } else {
                        this.cardFeel.visibility = View.GONE
                    }
                } else {
                    this.cardFeel.visibility = View.GONE
                }

                if (data.potensi != null) {
                    this.tvDetailsPotency.text = data.potensi
                } else {
                    this.cardPotency.visibility = View.GONE
                }

            }
        }
    }

    private fun setQuakeLocation(coordinate: LatLng, coordinateString: String) {
        symbolManager.create(
            SymbolOptions()
                .withLatLng(coordinate)
                .withIconImage(ICON_ID)
                .withIconSize(1f)
                .withIconOffset(arrayOf(0f, -1f))
                .withTextField(coordinateString)
                .withTextHaloColor("rgba(255, 255, 255, 100)")
                .withTextHaloWidth(5.0f)
                .withTextAnchor(Property.TEXT_ANCHOR_TOP)
                .withTextOffset(arrayOf(0f, 1.3f))
                .withDraggable(false)
        )
        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 5.0))
    }

    private fun getPreferenceMapStyle(): String {
        val preference = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val mapStyle = preference.getString(
            getString(R.string.pref_key_map_style),
            getString(R.string.pref_map_entry_streets)
        )
        if (mapStyle != null) {
            return when (mapStyle) {
                getString(R.string.pref_map_entry_streets) -> Style.MAPBOX_STREETS
                getString(R.string.pref_map_entry_outdoors) -> Style.OUTDOORS
                getString(R.string.pref_map_entry_satellite) -> Style.SATELLITE
                getString(R.string.pref_map_entry_satellite_streets) -> Style.SATELLITE_STREETS
                getString(R.string.pref_map_entry_light) -> Style.LIGHT
                getString(R.string.pref_map_entry_dark) -> Style.DARK
                getString(R.string.pref_map_entry_traffic_day) -> Style.TRAFFIC_DAY
                getString(R.string.pref_map_entry_traffic_night) -> Style.TRAFFIC_NIGHT
                else -> Style.MAPBOX_STREETS
            }
        }
        return Style.MAPBOX_STREETS
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> super.onBackPressed()
        }
        return true
    }

    companion object {
        private const val ICON_ID = "ICON_ID"
    }
}