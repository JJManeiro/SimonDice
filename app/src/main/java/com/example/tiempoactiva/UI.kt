package com.example.tiempoactiva

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiempoactiva.ui.theme.TiempoActivaTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text (
        text = "Hello $name!",
        modifier = modifier
    )
}
//comentario
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextoDelineado(){
    var name = remember { mutableStateOf("") }
    OutlinedTextField(
        value = name.value,
        modifier = Modifier.padding(30.dp),
        onValueChange = {
            name.value = it
        },
        label = { Text(text = "Name")})
}
@Composable
fun SimonSays(vm: MiViewModel) {

    Box(modifier = Modifier) {
    Text(text = "Ronda", Modifier.padding(start = 100.dp))
    Text(text = Datos.ronda.value.toString(),
        Modifier.padding(horizontal = 115.dp, vertical = 20.dp)
    )
        Azul(vm, Colores.Azul)
        Verde(vm, Colores.Verde)
        Amarillo(vm, Colores.Amarillo)
        Rojo(vm, Colores.Rojo)
        //start
        if (Datos.secuencia.count()==0){Start(vm)}
        else if (Datos.secuencia.count()>0) {Reset(vm)}
    Button(onClick = {vm.check()},
        Modifier.padding(horizontal = 105.dp, vertical = 220.dp),
            colors = ButtonDefaults.buttonColors
                (containerColor = Color(233,233,233))){
        Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "arrow")
        }
    }
}

@Composable
private fun Start(vm: MiViewModel) {
    Button(
        onClick = {
            vm.reset()
            vm.addSeq()
        },
        Modifier.padding(horizontal = 20.dp, vertical = 220.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = Color(233, 233, 233))
    ) {
        Text(text = "Start", color = Color(0, 0, 0))
    }
}
@Composable
private fun Reset(vm: MiViewModel) {
    Button(
        onClick = {
            vm.reset()
        },
        Modifier.padding(horizontal = 20.dp, vertical = 220.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = Color(233, 233, 233))
    ) {
        Text(text = "Reset", color = Color(0, 0, 0))
    }
}
@Composable
private fun Rojo(vm: MiViewModel, color: Colores) {
    Button(
        onClick = { vm.Uadd(2) },
        Modifier.padding(horizontal = 30.dp, vertical = 130.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = color.color.value)
    ) {
    }
}

@Composable
private fun Amarillo(vm: MiViewModel, color : Colores) {
    Button(
        onClick = { vm.Uadd(3) },
        Modifier.padding(horizontal = 100.dp, vertical = 130.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = color.color.value)
    ) {
    }
}

@Composable
private fun Verde(vm: MiViewModel,color: Colores) {
    Button(
        onClick = { vm.Uadd(1) },
        Modifier.padding(horizontal = 100.dp, vertical = 80.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = color.color.value)
    ) {
    }
}

@Composable
private fun Azul(vm: MiViewModel, color: Colores) {
    Button(
        onClick = { vm.Uadd(0) },
        Modifier.padding(horizontal = 30.dp, vertical = 80.dp),
        colors = ButtonDefaults.buttonColors
            (containerColor = color.color.value)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val vm: MiViewModel = MiViewModel()
    TiempoActivaTheme {
        SimonSays(vm)
    }
}