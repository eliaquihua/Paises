package com.example.practica.data.remote.repository.CountryRepositoryImpl.kt

import com.example.practica.data.remote.api.CountryApi.kt.CountryApi
import com.example.practica.data.remote.mapper.CountryMapper.kt.toDomain
import com.example.practica.domain.model.Country.kt.Country
import com.example.practica.domain.repository.CountryRepository.kt.CountryRepository

class CountryRepositoryImpl(private val api: CountryApi) : CountryRepository {
    override suspend fun getAllCountries(): List<Country> {
        return api.getAllCountries().map { it.toDomain() }
    }

    override suspend fun searchCountry(name: String): List<Country> {
        return api.searchCountryByName(name).map { it.toDomain() }
    }
}