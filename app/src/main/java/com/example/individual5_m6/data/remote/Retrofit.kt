package com.example.individual5_m6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    companion object {
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"
        fun getRetrofitTerreno(): Api {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(Api::class.java)
        }
    }
}