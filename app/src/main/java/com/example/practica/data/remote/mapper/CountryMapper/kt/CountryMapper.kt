package com.example.practica.data.remote.mapper.CountryMapper.kt

import com.example.practica.data.remote.dto.CountryDto.kt.CountryDto
import com.example.practica.domain.model.Country.kt.Country


fun CountryDto.toDomain(): Country {
    return Country(
        name = name.common,
        flagUrl = flags.png,
        capital = capital?.firstOrNull() ?: "No Capital",
        region = region ?: "Unknown",
        population = population
    )
}