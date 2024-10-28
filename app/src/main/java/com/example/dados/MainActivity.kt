package com.example.dados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dados.ui.theme.DadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DadosTheme(dynamicColor = false) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Inicio(name = "Android")
                }
            }
        }
    }
}

@Composable
fun Espacamento() {
    Spacer(modifier = Modifier.padding(16.dp))
}

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {
    var filmeEscolhido by remember { mutableStateOf(R.drawable.com_dia_) }
    var generoFilme by remember { mutableStateOf("Comédia") } // Valor inicial exibido

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 20.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Card(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Filme Aleatório",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif
            )
        }

        // Exibe a imagem do filme
        Image(
            painter = painterResource(id = filmeEscolhido),
            contentDescription = "Filme",
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 8.dp)
        )

        // Exibe o gênero do filme abaixo da imagem em um Card centralizado
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(150.dp)
        ) {
            Text(
                text = generoFilme, // Exibe o gênero do filme sorteado
                fontSize = 24.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

        Espacamento()

        // Botão para sortear o filme
        Button(
            onClick = {
                val sorteio = (1..6).random()
                when (sorteio) {
                    1 -> {
                        filmeEscolhido = R.drawable.a__o
                        generoFilme = "Ação"
                    }
                    2 -> {
                        filmeEscolhido = R.drawable.com_dia_
                        generoFilme = "Comédia"
                    }
                    3 -> {
                        filmeEscolhido = R.drawable.drama
                        generoFilme = "Drama"
                    }
                    4 -> {
                        filmeEscolhido = R.drawable.fic__o_cient_fica_
                        generoFilme = "Ficção Científica"
                    }
                    5 -> {
                        filmeEscolhido = R.drawable.suspense
                        generoFilme = "Suspense"
                    }
                    else -> {
                        filmeEscolhido = R.drawable.terror
                        generoFilme = "Terror"
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.Black
            )
        ) {
            Text("Sortear")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadosTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Inicio(name = "Android")
        }
    }
}
