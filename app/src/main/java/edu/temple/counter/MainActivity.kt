package edu.temple.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.temple.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { count++ }) {
            Image(
                painter = painterResource(android.R.drawable.arrow_up_float),
                contentDescription = "Up arrow"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "$count",
            fontSize = 192.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { count-- }) {
            Image(
                painter = painterResource(android.R.drawable.arrow_down_float),
                contentDescription = "Down arrow"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        Counter()
    }
}