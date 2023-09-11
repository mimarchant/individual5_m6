package com.example.individual5_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.individual5_m6.R
import com.example.individual5_m6.databinding.FragmentDetailBinding

private const val ARG_PARAM1 = "id"

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var param1: String? = null
    private val terrenoViewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        terrenoViewModel.terrenoLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvID.text = it.id
            binding.tvPrice.text = it.precio.toString()
            binding.tvType.text = it.tipo
            binding.imag.load(it.imagen)
        }
        return binding.root
    }
}