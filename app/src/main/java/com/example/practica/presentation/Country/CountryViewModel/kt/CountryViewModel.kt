package com.example.practica.presentation.Country.CountryViewModel.kt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica.domain.model.Country.kt.Country
import com.example.practica.domain.repository.CountryRepository.kt.CountryRepository
import com.example.practica.presentation.Country.CountryState.kt.CountryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(
    private val repository: CountryRepository
) : ViewModel() {

    var state by mutableStateOf(CountryState())
        private set
    var detailState by mutableStateOf<CountryDetailState>(CountryDetailState.Loading)
        private set

    private var allCountries: List<Country> = emptyList()

    init {
        loadCountries()
    }

    fun loadCountries() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val result = repository.getAllCountries()
                allCountries = result
                state = state.copy(isLoading = false, countries = result)
            } catch (e: Exception) {
                state = state.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun searchCountry(name: String) {
        state = if (name.isBlank()){
            state.copy(countries = allCountries)
        } else{
            val filtered = allCountries.filter {
                it.name.contains(name, ignoreCase = true)
            }
            state.copy(countries = filtered)
        }
    }

    fun getCountryByName(name: String?) {
        detailState = CountryDetailState.Loading

        if (allCountries.isEmpty()){
            viewModelScope.launch {
                try {
                    val result = repository.getAllCountries()
                    allCountries = result
                    buscarYActualizarEstado(name)

                } catch (e: Exception){
                    detailState = CountryDetailState.Error("Error al cargar países: ${e.message}")
                }
            }
        } else {
            buscarYActualizarEstado(name)
        }

    }
    private fun buscarYActualizarEstado(name: String?) {
        val country = allCountries.find { it.name.equals(name, ignoreCase = true) }
        detailState = if (country != null) {
            CountryDetailState.Success(country)
        } else {
            CountryDetailState.Error("PAÍS NO ENCONTRADO")
        }
    }
}

