package com.example.practica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practica.presentation.Country.CountryDetailScreen.CountryDetailScreen
import com.example.practica.presentation.Country.CountryScreen.CountryScreen
import com.example.practica.theme.PracticaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "country_list") {
                    composable("country_list") {
                        CountryScreen(navController)
                    }
                    composable("country_detail/{countryName}") { backStackEntry ->
                        val countryName = backStackEntry.arguments?.getString("countryName")
                        CountryDetailScreen(countryName)
                    }
                }
            }
        }
    }
}
