package com.example.practica.domain.repository.CountryRepository.kt

import com.example.practica.domain.model.Country.kt.Country

interface CountryRepository {
    suspend fun getAllCountries(): List<Country>
    suspend fun searchCountry(name: String): List<Country>
}