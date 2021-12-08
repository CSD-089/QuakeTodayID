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
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.quaketodayid.BaseApp
import com.example.quaketodayid.R
import com.example.quaketodayid.data.network.StatusResponse
import com.example.quaketodayid.databinding.FragmentDashboardBinding
import com.example.quaketodayid.databinding.FragmentRatingBinding
import com.example.quaketodayid.di.VMFactory
import com.example.quaketodayid.ui.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val nestedNavHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_dashboard) as? NavHostFragment

        val navController = nestedNavHostFragment?.navController

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        if (navController != null) {
            bottomNavigationView.setupWithNavController(navController)
        } else {
            throw RuntimeException("Controller not found")
        }


    }


}