package com.clemente.tecsupfit.Screens.Detalle


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.model.Clase


@Composable
fun DetalleClaseScreen(
    clase: Clase,
    onReservarClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = clase.nombre
        )

        Text(
            text = clase.horario
        )

        Text(
            text = clase.sala
        )

        Button(
            onClick = onReservarClick
        ) {
            Text("Reservar cupo")
        }
    }
}