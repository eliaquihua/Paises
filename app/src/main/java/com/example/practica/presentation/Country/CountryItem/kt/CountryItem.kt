package com.example.practica.presentation.Country.CountryItem.kt

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practica.domain.model.Country.Country



@Composable
fun CountryItem(country: Country, modifier: Modifier = Modifier,
                onClick: () -> Unit)
{
    Card(
    modifier = modifier.padding(8.dp).clickable { onClick() })
    {
    Text(
        text = country.name,
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
    )
    }
}
