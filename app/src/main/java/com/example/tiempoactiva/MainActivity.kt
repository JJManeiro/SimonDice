package com.example.tiempoactiva

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.tiempoactiva.ui.theme.TiempoActivaTheme


class MainActivity : ComponentActivity() {
    var appStartTime: Long = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // instanciamos el viewModel
        val vm: MiViewModel = MiViewModel()
        appStartTime = System.currentTimeMillis()
        setContent {
            TiempoActivaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Brave,new world.")

                    SimonSays(vm)
                    // TextoDelineado()
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Estado","estoy arrancando");
        appStartTime = SystemClock.elapsedRealtime()
    }
    override fun onResume() {
        super.onResume()
        Log.d("Estado","estoy onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estado","estoy en Pausa");
        val ElapsedTime = SystemClock.elapsedRealtime() - appStartTime
        Log.d("Estado", "pasaron "+ ElapsedTime/1000+" s")
    }
}

