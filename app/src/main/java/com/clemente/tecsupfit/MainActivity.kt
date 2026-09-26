package com.clemente.tecsupfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.clemente.tecsupfit.Screens.Confirmacion.ConfirmacionScreen
import com.clemente.tecsupfit.Screens.Detalle.DetalleClaseScreen
import com.clemente.tecsupfit.Screens.Inicio.InicioScreen
import com.clemente.tecsupfit.Screens.Perfil.PerfilScreen
import com.clemente.tecsupfit.Screens.Reserva.ReservasScreen
import com.clemente.tecsupfit.Screens.Rutinas.RutinasScreen
import com.clemente.tecsupfit.components.BottomBar
import com.clemente.tecsupfit.model.Clase
import com.clemente.tecsupfit.model.clases
import com.clemente.tecsupfit.ui.theme.TecsupFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TecsupFitTheme {
                TECSUPFitApp()
            }
        }
    }
}


private val bottomBarRoutes = listOf("inicio", "reservas", "rutinas", "perfil")

@Composable
fun TECSUPFitApp() {

    val reservas = remember {
        mutableStateListOf<Clase>()
    }

    val onCancelReserva: (Clase) -> Unit = { clase ->
        reservas.remove(clase)
    }

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route


    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),

        bottomBar = {
            
            if (currentRoute in bottomBarRoutes) {
                BottomBar(
                    currentRoute = currentRoute,

                    OnInicioClick={
                        navController.navigate("inicio")
                    },

                    OnReservaClick = {
                        navController.navigate("reservas")
                    },
                    OnPerfilClick = {
                        navController.navigate("perfil")
                    },
                    OnRutinasClick = {
                        navController.navigate("rutinas")
                    }
                )
            }
        }

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "inicio",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("inicio") {

                InicioScreen(
                    onClaseClick = { clase ->

                        navController.navigate(
                            "detalle/${clase.id}"
                        )
                    }
                )
            }

            composable(
                route = "detalle/{claseId}"
            ) { backStackEntry ->

                val claseId = backStackEntry
                    .arguments
                    ?.getString("claseId")
                    ?.toIntOrNull()

                val clase = clases.find {
                    it.id == claseId
                }

                if (clase != null) {

                    DetalleClaseScreen(
                        clase = clase,
                        onBackClick = {
                            navController.navigateUp()
                        },
                        onReservarClick = {

                            if (!reservas.contains(clase)) {
                                reservas.add(clase)
                            }

                            navController.navigate(
                                "confirmacion/${clase.id}"
                            )
                        }
                    )
                }
            }

            composable(
                route = "confirmacion/{claseId}"
            ) { backStackEntry ->

                val claseId = backStackEntry
                    .arguments
                    ?.getString("claseId")
                    ?.toIntOrNull()

                val clase = clases.find {
                    it.id == claseId
                }

                if (clase != null) {

                    ConfirmacionScreen(
                        clase = clase,
                        onBackClick = {
                            navController.navigateUp()
                        },
                        onVerReservasClick = {
                                navController.navigate("reservas")
                        }
                    )
                }
            }

            composable("reservas") {

                ReservasScreen(
                    reservas = reservas,
                    onCancelReserva = onCancelReserva,
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable("perfil") {
                PerfilScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable ("rutinas") {
                RutinasScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}