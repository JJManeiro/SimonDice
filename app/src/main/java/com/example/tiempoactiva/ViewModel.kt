package com.example.tiempoactiva

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
        Log.d("random",Datos.secuencia.toString())
    }
    fun Uadd(n: Int){
        Datos.Usecuencia.add(n)
        Log.d("val",Datos.Usecuencia.toString())
    }
    fun show(){
        print(Datos.secuencia.toString())
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
            Log.d("val","ganaste esta")
            if (Datos.ronda.value > Datos.record.value) {
                Datos.record = Datos.ronda
            }
            resetUseq()
        }
        else{
            Datos.estado = Estado.GameOver
            Log.d("val","perdiste")
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