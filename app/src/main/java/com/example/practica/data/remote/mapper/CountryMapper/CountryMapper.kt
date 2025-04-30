package com.example.practica.data.remote.mapper.CountryMapper

import com.example.practica.data.remote.dto.CountryDto.CountryDto
import com.example.practica.domain.model.Country.Country

fun CountryDto.toDomain(): Country {
    return Country(
        name = name.common,
        flagUrl = flags.png,
        capital = capital?.firstOrNull() ?: "No Capital",
        region = region ?: "Unknown",
        population = population
    )
}