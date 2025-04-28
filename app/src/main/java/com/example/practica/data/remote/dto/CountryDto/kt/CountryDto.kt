package com.example.practica.data.remote.dto.CountryDto.kt

data class CountryDto(
    val name: NameDto,
    val flags: FlagDto,
    val capital: List<String>?,
    val region: String?,
    val population: Int
)

data class NameDto(val common: String)
data class FlagDto(val png: String)
