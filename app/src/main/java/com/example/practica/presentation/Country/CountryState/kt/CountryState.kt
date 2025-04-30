package com.example.practica.presentation.Country.CountryState.kt

import com.example.practica.domain.model.Country.Country

data class CountryState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String? = null
)
