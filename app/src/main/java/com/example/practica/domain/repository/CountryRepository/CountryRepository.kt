package com.example.practica.domain.repository.CountryRepository

import com.example.practica.domain.model.Country.Country

interface CountryRepository {
    suspend fun getAllCountries(): List<Country>
    suspend fun searchCountry(name: String): List<Country>
}