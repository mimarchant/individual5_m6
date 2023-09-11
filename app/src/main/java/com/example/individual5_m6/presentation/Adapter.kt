package com.example.individual5_m6.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.individual5_m6.R
import com.example.individual5_m6.data.local.TerrenoEntity
import com.example.individual5_m6.databinding.ItemTerrenoBinding

class Adapter : RecyclerView.Adapter<Adapter.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding): RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity){
            v.img.load(terreno.imagen)
            v.img.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                bundle.putString("imagen", terreno.imagen)
                bundle.putString("precio", terreno.precio.toString())
                Navigation.findNavController(v.root)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }

    }
}