package com.example.individual5_m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.individual5_m6.data.Repository
import com.example.individual5_m6.data.local.TerrenoDatabase
import com.example.individual5_m6.data.remote.Retrofit
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio: Repository
    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    init {
        val terrenoApi = Retrofit.getRetrofitTerreno()
        val terrenoBaseDatos = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repository(terrenoApi, terrenoBaseDatos)
    }
    fun obtenerTerreno() = viewModelScope.launch{
        repositorio.cargarTerreno()
    }
    fun terrenoLiveData(id:String)= repositorio.getTerreno(id)
}