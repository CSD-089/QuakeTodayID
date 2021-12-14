package com.example.quaketodayid.ui.main.dashboard.terbaru

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentTerbaruBinding
import com.example.quaketodayid.ui.shakemap.ShakeMapViewActivity
import com.example.quaketodayid.utils.toGreen
import com.example.quaketodayid.utils.toRed
import com.example.quaketodayid.utils.toYellow
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class TerbaruFragment : Fragment() {

    private val viewModel: TerbaruViewModel by viewModels()

    private var _binding: FragmentTerbaruBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTerbaruBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLoadingState(true)
        viewModel.getAutoGempa.observe(viewLifecycleOwner, { response ->
            when (response.status) {
                StatusResponse.SUCCESS -> {
                    setLoadingState(false)
                    val data = response.body?.infogempa?.gempa!!
                    loadData(data)
                }
                StatusResponse.EMPTY -> {
                    setLoadingState(false)
                    loadData(GempaItem())
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
        binding.apply {
            if (state) {
                pbLoading.visibility = View.VISIBLE
                
                tvNewLabelLocation.visibility = View.INVISIBLE
                tvNewLabelDatetime.visibility = View.INVISIBLE
                tvNewLabelFeels.visibility = View.INVISIBLE
                tvNewLabelPotency.visibility = View.INVISIBLE
                tvNewLabelDepth.visibility = View.INVISIBLE
                
                tvNewPotency.visibility = View.INVISIBLE
                tvNewLocation.visibility = View.INVISIBLE
                tvNewFeels.visibility = View.INVISIBLE
                tvNewDatetime.visibility = View.INVISIBLE
                tvNewLastUpdate.visibility = View.INVISIBLE
                tvNewDepth.visibility = View.INVISIBLE
                cardView.visibility = View.INVISIBLE
                
                btnShowShakeMap.visibility = View.INVISIBLE
            } else {
                pbLoading.visibility = View.GONE

                tvNewLabelLocation.visibility = View.VISIBLE
                tvNewLabelDatetime.visibility = View.VISIBLE
                tvNewLabelFeels.visibility = View.VISIBLE
                tvNewLabelPotency.visibility = View.VISIBLE
                tvNewLabelDepth.visibility = View.VISIBLE

                tvNewPotency.visibility = View.VISIBLE
                tvNewLocation.visibility = View.VISIBLE
                tvNewFeels.visibility = View.VISIBLE
                tvNewDatetime.visibility = View.VISIBLE
                tvNewLastUpdate.visibility = View.VISIBLE
                tvNewDepth.visibility = View.VISIBLE
                cardView.visibility = View.VISIBLE

                btnShowShakeMap.visibility = View.VISIBLE
            }
        }
    }

    private fun loadData(item: GempaItem) {
        with(binding) {
            val currentTimeMillis = System.currentTimeMillis()
            val date = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
                .format(currentTimeMillis)
            val lastUpdate = "Pembaruan terakhir: $date"
            tvNewLastUpdate.text = lastUpdate
            
            val magnitude = "${item.magnitude}SR"
            tvNewMagnitude.text = magnitude
            when (item.magnitude?.toDouble()!!) {
                in 0.0..4.9 -> {
                    tvNewMagnitude.setTextColor(
                        ContextCompat.getColor(requireContext(), android.R.color.black)
                    )
                    cardView.toGreen()
                }
                in 5.0..6.9 -> {
                    tvNewMagnitude.setTextColor(
                        ContextCompat.getColor(requireContext(), android.R.color.black)
                    )
                    cardView.toYellow()
                }
                else -> {
                    tvNewMagnitude.setTextColor(
                        ContextCompat.getColor(requireContext(), android.R.color.white)
                    )
                    cardView.toRed()
                }
            }

            tvNewDepth.text = item.kedalaman

            tvNewLocation.text = item.wilayah
            val feels = if (item.dirasakan == "-") "Tidak ada laporan" else item.dirasakan
            tvNewFeels.text = feels

            tvNewPotency.text = item.potensi
            
            val dateTime = "${item.tanggal} ${item.jam}"
            tvNewDatetime.text = dateTime
            btnShowShakeMap.setOnClickListener {
                val intent = Intent(requireContext(), ShakeMapViewActivity::class.java)
                intent.putExtra(ShakeMapViewActivity.EXTRA_SHAKEMAP_DATA, item.shakemap)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    requireActivity(), btnShowShakeMap, "shakemap"
                ).toBundle()
                requireActivity().startActivity(intent, options)
            }
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