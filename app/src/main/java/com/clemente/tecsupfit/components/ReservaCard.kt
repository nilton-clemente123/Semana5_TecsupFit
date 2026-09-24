package com.clemente.tecsupfit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.model.Clase

@Composable
fun ReservaCard(
    clase: Clase
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = clase.nombre
            )

            Text(
                text = "${clase.horario} · ${clase.sala}"
            )

            Text(
                text = "Confirmada"
            )
        }
    }
}