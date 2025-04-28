package com.example.practica.data.remote.api.CountryApi.kt

import com.example.practica.data.remote.dto.CountryDto.kt.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {
    @GET("all")
    suspend fun getAllCountries(): List<CountryDto>

    @GET("name/{name}")
    suspend fun searchCountryByName(@Path("name") name: String): List<CountryDto>
}