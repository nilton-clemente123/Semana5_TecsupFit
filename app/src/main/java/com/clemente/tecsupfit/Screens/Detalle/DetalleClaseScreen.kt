package com.clemente.tecsupfit.Screens.Detalle


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clemente.tecsupfit.components.TecsupTopBar
import com.clemente.tecsupfit.model.Clase


@Composable
fun DetalleClaseScreen(
    clase: Clase,
    onBackClick: () -> Unit,
    onReservarClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TecsupTopBar(
            title = "Detalle de clase",
            onBack = onBackClick
        )




        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .background(
                            color = Color(0xFFD9E8D9),
                            shape = RoundedCornerShape(12.dp)
                        ).fillMaxWidth().height(85.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.FitnessCenter,
                        contentDescription = "Mancuerna",
                        tint = Color(26, 79, 28, 255),
                        modifier = Modifier.size(65.dp)
                    )
                }

                Text(
                    text = clase.nombre,
                    fontWeight = FontWeight.Bold
                )

                Row() {
                    Text(
                        text = clase.horario
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = clase.sala
                    )
                }



                Text(
                    text = clase.descripcion
                )
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "${clase.cupos}"
                )
            }





            Button(
                onClick = onReservarClick,
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A4F1C),
                    contentColor = Color.White
                )
            ) {
                Text("Reservar cupo",
                    fontSize = 20.sp)
            }
        }
    }
}