package com.example.jetpackcomposetraining

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetraining.ui.theme.JetpackComposeTrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTrainingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StateExample()
                }
            }
        }
    }
}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun MyColum(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize(), Arrangement.Center) {
        Text("Ejemplo1", modifier.background(Color.Blue))
    }
}

@Composable
fun MyRow(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxSize()) {

    }
}

@Composable
fun ElementFusion() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Blue), Alignment.Center
        ) {
            Text(text = "Ejemplo1")
        }
        MySpacerHeight(space = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), Alignment.Center
            ) {
                Text(text = "Ejemplo2")
            }
            MySpacerWidth(space = 30)
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red), Alignment.Center
            ) {
                Text(text = "Ejemplo3")
            }
        }
        MySpacerHeight(space = 30)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo4")
        }
    }
}

@Composable
fun MySpacerHeight(space: Int) {
    Spacer(Modifier.height(space.dp))
}

@Composable
fun MySpacerWidth(space: Int) {
    Spacer(Modifier.width(space.dp))
}

@Composable
fun StateExample() {

    var counter = rememberSaveable() { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "He pulsado ${counter.value} veces")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    JetpackComposeTrainingTheme {
        StateExample()
    }
}