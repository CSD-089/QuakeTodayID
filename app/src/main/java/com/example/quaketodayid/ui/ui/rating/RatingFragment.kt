package com.example.quaketodayid.ui.ui.rating

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.quaketodayid.BaseApp
import com.example.quaketodayid.databinding.FragmentRatingBinding
import com.example.quaketodayid.di.VMFactory
import com.example.quaketodayid.ui.MainViewModel
import javax.inject.Inject

class RatingFragment : Fragment() {

    @Inject
    lateinit var factory: VMFactory
    private val viewModel: MainViewModel by viewModels {
        factory
    }
    private var _binding: FragmentRatingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BaseApp).appComponents.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAutoGempa().observe(viewLifecycleOwner, Observer { movie ->
            binding.textGallery.text = movie.body.toString()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}