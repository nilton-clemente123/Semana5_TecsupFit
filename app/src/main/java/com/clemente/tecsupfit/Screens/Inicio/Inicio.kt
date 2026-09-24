package com.clemente.tecsupfit.Screens.Inicio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun InicioScreen( modifier: Modifier = Modifier) {

    val filtros = listOf(
        "Hoy",
        "Esta semana"
    )

    val clases = listOf(
        "Yoga funcional - 7:00 am · Sala 2",
        "Cross Training - 6:00 pm · Sala 1",
        "Spinning - 7:30 pm · Sala 3"
    )

    var filtroSeleccionado = remember {
        mutableStateOf("Hoy")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(filtros) { filtro ->

                FilterChip(
                    selected = filtroSeleccionado.value == filtro,
                    onClick = {
                        filtroSeleccionado.value = filtro
                    },
                    label = {
                        Text(filtro)
                    }
                )
            }
        }

        Text(
            text = "Clases disponibles",
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 8.dp
                )
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            items(clases) { clase ->

                ClaseCard(
                    clase = clase
                )
            }
        }
    }
}

@Composable
fun ClaseCard(
    clase: String
) {

    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = clase,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}