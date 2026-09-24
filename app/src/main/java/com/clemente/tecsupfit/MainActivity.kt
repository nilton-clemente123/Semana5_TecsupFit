package com.clemente.tecsupfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clemente.tecsupfit.Screens.Confirmacion.ConfirmacionScreen
import com.clemente.tecsupfit.Screens.Detalle.DetalleClaseScreen
import com.clemente.tecsupfit.Screens.Inicio.InicioScreen
import com.clemente.tecsupfit.components.BottomBar
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TECSUPFitApp() {

    val navController = rememberNavController()

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("TECSUP Fit")
                }
            )
        },

        bottomBar = {
            BottomBar()
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
                        onReservarClick = {
                            navController.navigate("confirmacion/${clase.id}")
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
                        onVerReservasClick = {

                        }
                    )
                }
            }
        }
    }
}