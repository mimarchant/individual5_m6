package com.example.individual5_m6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("realestate")//endpoint
    suspend fun getData(): Response<List<Terreno>>
}