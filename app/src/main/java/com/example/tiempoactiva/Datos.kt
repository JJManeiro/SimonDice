package com.example.tiempoactiva

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

object Datos {
    var ronda = mutableStateOf(0)
    var record = mutableStateOf(0)
    var secuencia = mutableListOf<Int>()
    var Usecuencia = mutableListOf<Int>()
    var estado = Estado.Inicio
}
enum class Estado {
    Inicio,
    Secuencia,
    Pausa,
    Check,
    Usuario,
    GameOver,
}
