package com.example.tiempoactiva

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MiViewModel: ViewModel() {
    private val Tag_log: String = "ViewModel"
    init{
        Log.d(Tag_log,"Empieza ViewModel")
    }
    fun espera(segundos: Long){
        viewModelScope.launch {
            Log.d("corutina","Esperando en el Viewmodel...")
            delay(segundos)
            Log.d("corutina","Listo en el ViewModel!")
        }
    }
    fun add(){
        Datos.secuencia.add((0..3).random())
        Log.d("corutina",Datos.secuencia.toString())
    }
    fun Uadd(n: Int){
        Datos.Usecuencia.add(n)
        Log.d("corutina",Datos.Usecuencia.toString())
    }
    fun show(){
        viewModelScope.launch {
            for (numero in Datos.secuencia) {
                when (numero) {
                    0 -> {
                        Colores.Azul.color.value= Color(130,235,255)
                        delay(500L)
                        Colores.Azul.color.value= Color(0,0,233)
                        delay(500L)
                    }

                    1 -> {
                        Colores.Verde.color.value = Color(175,245,90)
                        delay(500L)
                        Colores.Verde.color.value = Color(0,233,0)
                        delay(500L)
                    }

                    2 -> {
                        Colores.Rojo.color.value = Color(255,205,255)
                        delay(500L)
                        Colores.Rojo.color.value = Color(233,0,0)
                        delay(500L)
                    }

                    3 -> {
                        Colores.Amarillo.color.value = Color(250,215,105)
                        delay(500L)
                        Colores.Amarillo.color.value = Color(233,233,0)
                        delay(500L)
                    }
                }
            }
        }
    }
    fun reset(){
        resetRound()
        resetseq()
        resetUseq()
        Datos.estado = Estado.Inicio
    }
    fun addSeq(){
        Datos.estado = Estado.Secuencia
        add()
        show()
        Datos.estado = Estado.Pausa
    }

    fun check(){
        Datos.estado = Estado.Check
        if (Datos.secuencia == Datos.Usecuencia) {
            Datos.ronda.value++
            Log.d("corutina","ganaste esta")
            if (Datos.ronda.value > Datos.record.value) {
                Datos.record = Datos.ronda
            }
            resetUseq()
            addSeq()
        }
        else{
            Datos.estado = Estado.GameOver
            Log.d("corutina","perdiste")
        }
    }
    fun resetRound(){
        Datos.ronda.value=0
    }
    fun resetseq(){
        Datos.secuencia= mutableListOf<Int>();
    }
    fun resetUseq(){
        Datos.Usecuencia= mutableListOf<Int>();
    }
    fun testSeq(){
        for (i in 0..3) {
            Datos.secuencia.add(1)
        }
        Log.d("val",Datos.secuencia.toString())
    }
}