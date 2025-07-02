package com.example.cars_shift_2025.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CarApiFactory {
    private const val BASE_URL = "https://shift-intensive.ru/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}