package com.example.quaketodayid.ui.ui.terbaru

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.quaketodayid.BuildConfig
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentTerbaruBinding
import com.example.quaketodayid.ui.MainViewModel
import com.example.quaketodayid.utils.loadUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TerbaruFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentTerbaruBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTerbaruBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAutoGempa().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    val data = response.body.infogempa?.gempa!!
                    with(binding) {
                        lastUpdate.text = "Last update ${data.jam}"
                        srScale.text = "${data.magnitude}SR"
                        location.text = data.wilayah
                        coordinate.text = data.coordinates
                        potency.text = data.potensi
                        dateTime.text = "${data.tanggal}, ${data.jam}"
                        shakemap.loadUrl(BuildConfig.BASE_URL+data.shakemap)
                    }
                }
                StatusResponse.EMPTY -> {
                }
                StatusResponse.ERROR -> {
                }
            }
        })
    }

}