package com.example.practica.presentation.Country.CountryDetailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.practica.presentation.Country.CountryViewModel.kt.CountryDetailState
import com.example.practica.presentation.Country.CountryViewModel.kt.CountryViewModel


@Composable
fun CountryDetailScreen(
    countryName: String?,
    viewModel: CountryViewModel = hiltViewModel()
) {
    LaunchedEffect(countryName) {
        viewModel.getCountryByName(countryName)
    }

    when ( val state = viewModel.detailState){
        is CountryDetailState.Loading -> {
          Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
              CircularProgressIndicator()
          }
        }
        is CountryDetailState.Success -> {
            val country = state.country
            Column (Modifier.padding(16.dp)){
                AsyncImage(
                    model = country.flagUrl,
                    contentDescription = "Bandera de ${country.name}",
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Nombre: ${country.name}", style = MaterialTheme.typography.titleLarge)
                Text("Capital: ${country.capital}")
                Text("Región: ${country.region}")
                Text("Población: ${country.population}")
            }
        }
        is CountryDetailState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
               Text(state.message)
            }
        }
    }
}