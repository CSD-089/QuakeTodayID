package com.example.quaketodayid.ui.ui.dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.quaketodayid.BaseApp
import com.example.quaketodayid.R
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentDashboardBinding
import com.example.quaketodayid.databinding.FragmentRatingBinding
import com.example.quaketodayid.di.VMFactory
import com.example.quaketodayid.ui.MainViewModel
import javax.inject.Inject

class DashboardFragment : Fragment() {

    @Inject
    lateinit var factory: VMFactory
    private val viewModel: MainViewModel by viewModels {
        factory
    }
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BaseApp).appComponents.inject(this)
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAutoGempa().observe(viewLifecycleOwner, Observer { response->
            when(response.status){
                StatusResponse.SUCCESS->{
                    val data = response.body.infogempa?.gempa!!
                    with(binding){
                        lastUpdate.text = "Last update ${data.jam}"
                        srScale.text = "${data.magnitude}SR"
                        location.text = data.wilayah
                        coordinate.text = data.coordinates
                        feel.text = data.wilayah
                        dateTime.text= "${data.tanggal}, ${data.jam}"
                    }
                }
                StatusResponse.EMPTY->{}
                StatusResponse.ERROR->{}
            }
        })
    }


}