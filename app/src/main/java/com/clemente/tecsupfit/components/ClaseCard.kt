package com.clemente.tecsupfit.components

import androidx.compose.foundation.clickable
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

        Column(
            modifier = Modifier
                .padding(16.dp).fillMaxWidth()
        ) {

            Text(
                text = clase.nombre
            )

            Text(
                text = "${clase.horario} · ${clase.sala}"
            )
        }
    }
}