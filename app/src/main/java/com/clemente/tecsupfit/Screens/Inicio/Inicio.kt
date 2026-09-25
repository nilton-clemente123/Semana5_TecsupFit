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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.components.ClaseCard
import com.clemente.tecsupfit.components.TecsupTopBar
import com.clemente.tecsupfit.model.Clase
import com.clemente.tecsupfit.model.clases


@Composable
fun InicioScreen(
    modifier: Modifier = Modifier,
    onClaseClick: (Clase) -> Unit
) {

    val filtros = listOf(
        "Hoy",
        "Esta semana"
    )

    var filtroSeleccionado = remember {
        mutableStateOf("Hoy")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        TecsupTopBar(
            title = "TECSUP Fit",
            subtitle = "Hola clemente"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
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
                fontWeight = FontWeight.Bold,
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
                        clase = clase,
                        onClick = {
                            onClaseClick(clase)
                        }
                    )
                }
            }
        }
    }
}
