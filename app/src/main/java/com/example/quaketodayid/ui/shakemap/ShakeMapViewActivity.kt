package com.example.quaketodayid.ui.shakemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.quaketodayid.BuildConfig
import com.example.quaketodayid.databinding.ActivityShakeMapViewBinding
import com.example.quaketodayid.utils.loadUrl

class ShakeMapViewActivity : AppCompatActivity() {

    private var binding: ActivityShakeMapViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShakeMapViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = ""

            val bundle = intent.extras
            if (bundle != null) {
                val shakeMap = bundle.getString(EXTRA_SHAKEMAP_DATA)
                if (shakeMap != null) {
                    tivShakeMap.loadUrl(BuildConfig.BASE_URL + shakeMap)
                } else {
                    Toast.makeText(
                        this@ShakeMapViewActivity,
                        "Maaf, aktivitas ini hanya meminta data shakemap dari BMKG agar bisa ditampilkan!",
                        Toast.LENGTH_SHORT
                    ).show()
                    onBackPressed()
                }
            } else {
                Toast.makeText(
                    this@ShakeMapViewActivity,
                    "Maaf, aktivitas ini hanya meminta data shakemap dari BMKG agar bisa ditampilkan!",
                    Toast.LENGTH_SHORT
                ).show()
                onBackPressed()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return true
    }

    override fun onBackPressed() {
        finishAfterTransition()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val EXTRA_SHAKEMAP_DATA = "extra_shakemap_data"
    }
}