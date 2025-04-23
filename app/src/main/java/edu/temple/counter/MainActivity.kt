package edu.temple.counter

import android.R.attr.text
import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    // Use remember to hold the state of the counter

    var count by remember { mutableIntStateOf(0) }


    Column(

        modifier = modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "↑")
        }
        Text(
            text = "${count}",
            fontSize = 192.sp
        )
        Button(
            onClick = { count-- },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = " ↓")
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