package com.clemente.tecsupfit.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun BottomBar(
    currentRoute: String?,
    OnInicioClick: () -> Unit,
    OnReservaClick: () -> Unit,
    OnPerfilClick: () -> Unit,
    OnRutinasClick: () -> Unit,
) {

    NavigationBar {

        NavigationBarItem(
            selected = currentRoute == "inicio",
            onClick = {
                OnInicioClick()
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                    contentDescription = "Inicio"
                )
            },
            label = {
                Text("Inicio")
            }
        )

        NavigationBarItem(
            selected = currentRoute == "reservas",
            onClick = {
                OnReservaClick()
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                    contentDescription = "Reservas"
                )
            },
            label = {
                Text("Reservas")
            }
        )

        NavigationBarItem(
            selected = currentRoute == "rutinas",
            onClick = { OnRutinasClick()},
            icon = {
                Icon(
                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                    contentDescription = "Rutinas"
                )
            },
            label = {
                Text("Rutinas")
            }
        )

        NavigationBarItem(
            selected = currentRoute == "perfil",
            onClick = { OnPerfilClick() },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                    contentDescription = "Perfil"
                )
            },
            label = {
                Text("Perfil")
            }
        )
    }
}