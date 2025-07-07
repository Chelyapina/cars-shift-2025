package com.example.cars_shift_2025.data

import com.example.cars_shift_2025.data.models.ListCarDto
import com.example.cars_shift_2025.data.models.ListCarWithRentsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CarApiService {
    @GET("/api/cars/info")
    suspend fun getCarsList() : ListCarDto

    @GET("/api/cars/info/{carId}")
    suspend fun getCarById(
        @Path(QUERY_PARAM_CAR_ID) id: String
    ) : ListCarWithRentsDto

    companion object{
        private const val QUERY_PARAM_CAR_ID = "carId"
    }
}