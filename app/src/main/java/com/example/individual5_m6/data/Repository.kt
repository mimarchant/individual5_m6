package com.example.individual5_m6.data

import androidx.lifecycle.LiveData
import com.example.individual5_m6.data.local.Dao
import com.example.individual5_m6.data.local.TerrenoEntity
import com.example.individual5_m6.data.remote.Api
import com.example.individual5_m6.data.remote.Terreno

class Repository(private val terrenoApi: Api, private val terrenoDao: Dao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()

    suspend fun cargarTerreno() {

        val respuesta = terrenoApi.getData()

        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.transformar() }
                terrenoDao.insertarTerrenos(terrenosEntity)
            }
        }

    }
    fun getTerreno(id: String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)

    fun Terreno.transformar(): TerrenoEntity =
        TerrenoEntity(this.id, this.precio, this.tipo, this.imagen)
}