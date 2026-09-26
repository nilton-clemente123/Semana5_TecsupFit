package com.clemente.tecsupfit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.model.Clase

@Composable
fun ReservaCard(
    clase: Clase,
    onCancel: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(20.dp)

        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Reserva confirmada",
                        tint = Color(26, 79, 28, 255)
                    )
                    Text(
                        text = clase.nombre,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                }

                Text(
                    text = "${clase.horario} · ${clase.sala}"
                )

                Text(
                    text = "Confirmada"
                )
            }

            IconButton(onClick = onCancel) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Cancelar reserva",
                    tint = Color(0xFFB00020)
                )
            }
        }
    }
}