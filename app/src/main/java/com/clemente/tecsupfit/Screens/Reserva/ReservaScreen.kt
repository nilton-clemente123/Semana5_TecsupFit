package com.clemente.tecsupfit.Screens.Reserva


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.components.ReservaCard
import com.clemente.tecsupfit.components.TecsupTopBar
import com.clemente.tecsupfit.model.Clase


@Composable
fun ReservasScreen(
    reservas: List<Clase>,
    onCancelReserva: (Clase) -> Unit,
    onBackClick: () -> Unit
) {

    var claseACancelar by remember { mutableStateOf<Clase?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TecsupTopBar(title = "Mis reservas", onBack = onBackClick)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            if (reservas.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Aún no tienes reservas")
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(reservas) { clase ->

                        ReservaCard(
                            clase = clase,
                            onCancel = { claseACancelar = clase }
                        )
                    }
                }
            }
        }

        claseACancelar?.let { clase ->
            AlertDialog(
                onDismissRequest = { claseACancelar = null },
                title = { Text("Cancelar reserva") },
                text = {
                    Text("¿Seguro que deseas cancelar tu reserva de ${clase.nombre}?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onCancelReserva(clase)
                            claseACancelar = null
                        }
                    ) {
                        Text("Sí, cancelar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { claseACancelar = null }) {
                        Text("No")
                    }
                }
            )
        }
    }
}