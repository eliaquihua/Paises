package com.example.practica.presentation.Country.CountryViewModel.kt

import com.example.practica.domain.model.Country.kt.Country

sealed class CountryDetailState {
    data object Loading : CountryDetailState()
    data class Success(val country: Country) : CountryDetailState()
    data class Error(val message: String) : CountryDetailState()
}