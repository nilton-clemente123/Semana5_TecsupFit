package com.clemente.tecsupfit.Screens.Confirmacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clemente.tecsupfit.components.TecsupTopBar
import com.clemente.tecsupfit.model.Clase


@Composable
fun ConfirmacionScreen(
    clase: Clase,
    onBackClick: () -> Unit,
    onVerReservasClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TecsupTopBar(
            title = "Confirmación",
            onBack = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Confirmación",
                tint = Color(116, 197, 118, 255),
                modifier = Modifier.size(90.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "¡Cupo reservado!",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = clase.nombre
            )

            Text(
                text = "${clase.horario} · ${clase.sala}"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onVerReservasClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE5E5E5),
                    contentColor = Color.White
                ),
                modifier = Modifier.height(50.dp)

            ) {
                Text("Ver mis reservas", color = Color(119, 119, 119, 255))
            }
        }
    }
}