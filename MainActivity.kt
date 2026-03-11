package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.example.myapplication.ui.theme.MyApplicationTheme


data class Mensagem(val author: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

                MensagemCard(msg = Mensagem(author = "Cinderela", body = "sapatinho"))
            }
        }
    }
}


@Composable
fun MensagemCard(msg: Mensagem) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.cinderela),
            contentDescription = "Imagem de perfil",
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Text(
                text = msg.author,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = msg.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Column {

            MensagemCard(Mensagem("Cinderela", "Loira"))
            MensagemCard(Mensagem("Cinderela", "Sapatinho"))
            MensagemCard(Mensagem("Cinderela", "gata borralheira"))
        }
    }
}