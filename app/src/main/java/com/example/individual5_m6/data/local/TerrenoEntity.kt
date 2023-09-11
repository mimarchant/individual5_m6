package com.example.individual5_m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_terreno")
data class TerrenoEntity(
    @PrimaryKey
    val id: String,
    val precio: Int,
    val tipo: String,
    val imagen: String
)