package com.clemente.tecsupfit.Screens.Confirmacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.model.Clase


@Composable
fun ConfirmacionScreen(
    clase: Clase,
    onVerReservasClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "¡Cupo reservado!"
        )

        Text(
            text = clase.nombre
        )

        Text(
            text = "${clase.horario} · ${clase.sala}"
        )

        Button(
            onClick = onVerReservasClick
        ) {
            Text("Ver mis reservas")
        }
    }
}