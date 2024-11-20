import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        var mostrarInicio = remember { mutableStateOf(true) }
        if (mostrarInicio.value) {
            Inicio(mostrarInicio)
        } else {
            Pantalla2()
        }

    }
}



@Composable
fun Inicio(mostrarInicio: MutableState<Boolean>) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(
            text = "Welcome to the Basics Codelabs!"
        )
        Button(onClick = {
            mostrarInicio.value = false
        }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun Pantalla2(modifier: Modifier = Modifier) {

    val textos: MutableList<String> = mutableListOf(
        "Hola me llamo Alvaro",
        "Me gusta la lasaña",
        "No se que más poner",
        "La mejor contraseña es 1234"
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        textos.forEach{ texto ->
            Row(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
                Fila(texto, modifier = Modifier)
            }
        }
    }
}

@Composable
fun Fila(texto:String, modifier: Modifier = Modifier){
    var expand = remember { mutableStateOf(false) }
    val expandPadding = if (expand.value) 70.dp else 0.dp
    Row (modifier = Modifier.background(Color.Red).fillMaxWidth().padding(15.dp, bottom = expandPadding), verticalAlignment = Alignment.CenterVertically){
        Text(
            text = texto,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { expand.value = !expand.value },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(if (expand.value) "Show less" else "Show more")
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
