package com.clemente.tecsupfit.Screens.Reserva


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(reservas) { clase ->

                    ReservaCard(
                        clase = clase,
                        onCancel = { onCancelReserva(clase) }
                    )
                }
            }
        }
    }
}