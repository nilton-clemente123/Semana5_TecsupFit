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
import com.clemente.tecsupfit.Screens.Inicio.InicioScreen
import com.clemente.tecsupfit.components.BottomBar
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

        InicioScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}