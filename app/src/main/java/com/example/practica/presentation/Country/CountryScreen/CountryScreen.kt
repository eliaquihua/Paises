package com.example.practica.presentation.Country.CountryScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.practica.presentation.Country.CountryItem.kt.CountryItem
import com.example.practica.presentation.Country.CountryViewModel.kt.CountryViewModel


@Composable

fun CountryScreen(
    navController : NavController,
    viewModel: CountryViewModel = hiltViewModel()) {

    val state by remember { derivedStateOf { viewModel.state }}
    var query by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        if (query.isBlank()){
            viewModel.searchCountry("")
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 32.dp)
    ) {
        TextField(
            value = query,
            onValueChange = {
                query = it
               viewModel.searchCountry(it)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Buscar país") }
        )
        when {
            state.isLoading-> {
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            state.error != null -> {
                Text("ERROR: ${state.error}", color = Color.Red)
            }
            else -> {
                LazyColumn {
                    items(state.countries) { country ->
                        CountryItem(
                            country = country,
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                            navController.navigate("country_detail/${country.name}")
                        }
                        )
                    }
                }
            }
        }
    }
}



