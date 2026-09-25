package com.clemente.tecsupfit.Screens.Rutinas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.components.TecsupTopBar

@Composable
fun RutinasScreen(
    onBackClick: () -> Unit
) {

    val rutinas = listOf(
        "Rutina de fuerza",
        "Rutina de cardio",
        "Rutina de movilidad"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TecsupTopBar(title = "Mis rutinas", onBack = onBackClick)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Text(
                text = "Mis rutinas",
                style = MaterialTheme.typography.headlineSmall
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(rutinas) { rutina ->

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = rutina,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}