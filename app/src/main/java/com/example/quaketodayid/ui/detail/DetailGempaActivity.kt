package com.example.quaketodayid.ui.detail

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.databinding.ActivityDetailGempaBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailGempaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailGempaBinding

    private lateinit var data: GempaItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = ActivityDetailGempaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.getParcelableExtra("data")!!
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        with(binding) {
            location.text = data.wilayah
            time.text = "${data.tanggal}, ${data.jam}"
            magnitude.text = data.magnitude
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val rawLatLng = data.coordinates
        val lat = rawLatLng?.substringBefore(',')?.toDouble()
        val lng = rawLatLng?.substringAfter(',')?.toDouble()

        val sydney = LatLng(lat!!, lng!!)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,8.0f))
        mMap.addCircle(CircleOptions().center(sydney).radius(100.0).strokeWidth(0.5f).fillColor(
            Color.RED))
    }
}