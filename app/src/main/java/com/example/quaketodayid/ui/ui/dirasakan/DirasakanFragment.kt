package com.example.quaketodayid.ui.ui.dirasakan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentDirasakanBinding
import com.example.quaketodayid.ui.MainViewModel
import com.example.quaketodayid.ui.ui.terkini.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirasakanFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentDirasakanBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDirasakanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getGempaDirasakan().observe(viewLifecycleOwner, { response ->
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

}