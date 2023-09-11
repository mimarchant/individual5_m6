package com.example.individual5_m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.individual5_m6.databinding.FragmentListBinding


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val terrenoVM: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        binding.btnCargar.setOnClickListener{
            terrenoVM.obtenerTerreno()
            initAdapter()
        }
        return binding.root

    }

    private fun initAdapter() {
        val adapter = Adapter()
        binding.rvRecycler.adapter = adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}