package com.example.tiempoactiva

import androidx.compose.runtime.MutableState
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
enum class Colores (val color: MutableState<Color>) {
    Rojo (mutableStateOf(Color(233,0,0))),
    Verde (mutableStateOf(Color(0,233,0))),
    Amarillo(mutableStateOf(Color(233,233,0))),
    Azul(mutableStateOf(Color(0,0,233)))
}
