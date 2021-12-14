package com.example.quaketodayid.ui.main.dashboard.dirasakan

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quaketodayid.R
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentDirasakanBinding
import com.example.quaketodayid.ui.main.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirasakanFragment : Fragment() {

    private val viewModel: DirasakanViewModel by viewModels()

    private var _binding: FragmentDirasakanBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
        viewModel.getGempaDirasakan.observe(viewLifecycleOwner, { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    setLoadingState(false)
                    val data = response.body?.infogempa
                    adapter = ItemAdapter(data?.gempa!!)
                    binding.recyclerView.adapter = adapter
                }
                StatusResponse.EMPTY -> {
                    setLoadingState(false)
                    adapter = ItemAdapter(ArrayList())
                    binding.recyclerView.adapter = adapter
                }
                StatusResponse.ERROR -> {
                    setLoadingState(false)
                    Toast.makeText(
                        requireContext(),
                        "An error occurred, Please try again later.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    setLoadingState(true)
                }
            }
        })
    }

    private fun setLoadingState(state: Boolean) {
        if (state) {
            binding.pbLoading.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        } else {
            binding.pbLoading.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_dashboard_features, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_refresh) {
            viewModel.reload()
        }
        return true
    }
}