package com.example.practica.data.remote.repository.CountryRepositoryImpl.kt

import com.example.practica.data.remote.api.CountryApi.CountryApi
import com.example.practica.data.remote.mapper.CountryMapper.toDomain
import com.example.practica.domain.model.Country.Country
import com.example.practica.domain.repository.CountryRepository.CountryRepository

class CountryRepositoryImpl(private val api: CountryApi) : CountryRepository {
    override suspend fun getAllCountries(): List<Country> {
        return api.getAllCountries().map { it.toDomain() }
    }

    override suspend fun searchCountry(name: String): List<Country> {
        return api.searchCountryByName(name).map { it.toDomain() }
    }
}