package com.example.quaketodayid.ui.ui.terkini

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quaketodayid.BaseApp
import com.example.quaketodayid.BuildConfig
import com.example.quaketodayid.R
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentTerbaruBinding
import com.example.quaketodayid.databinding.FragmentTerkiniBinding
import com.example.quaketodayid.di.VMFactory
import com.example.quaketodayid.ui.MainViewModel
import com.example.quaketodayid.utils.loadUrl
import javax.inject.Inject


class TerkiniFragment : Fragment() {

    @Inject
    lateinit var factory: VMFactory
    private val viewModel: MainViewModel by viewModels {
        factory
    }
    private var _binding: FragmentTerkiniBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTerkiniBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getGempaTerbaru().observe(viewLifecycleOwner, Observer{ response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    val data = response.body.infogempa
                    adapter = ItemAdapter(data?.gempa!!)
                    binding.recyclerView.adapter = adapter
                }
                StatusResponse.EMPTY -> {
                }
                StatusResponse.ERROR -> {
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BaseApp).appComponents.inject(this)
    }

}