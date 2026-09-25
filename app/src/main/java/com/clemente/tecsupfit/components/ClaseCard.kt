package com.clemente.tecsupfit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.clemente.tecsupfit.model.Clase


@Composable
fun ClaseCard(
    clase: Clase,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp).clickable{
                onClick()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.FitnessCenter,
                contentDescription = "Mancuerna",
                tint = Color(26, 79, 28, 255),
                modifier = Modifier.padding(start = 16.dp).size(50.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {

                Text(
                    text = clase.nombre,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${clase.horario} · ${clase.sala}"
                )
            }
        }



    }
}