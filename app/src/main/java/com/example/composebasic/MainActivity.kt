package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "劉伊宸",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var x by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp) // Adding padding to the column
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp) // Space between rows
            ) {
                Button(onClick = { x = 0 }) {
                    Text("歸零")
                }
                Image(
                    painter = painterResource(id = R.drawable.ghost),
                    contentDescription = "嚇你",
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = x.toString(),
                fontSize = 50.sp,
                modifier = modifier
                    .clickable { x++ }
                    .padding(16.dp) // Padding around the text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 16.dp) // Space between rows
            ) {
                Text(
                    text = stringResource(R.string.author),
                    color = Color.Blue,
                    fontSize = 50.sp,
                    fontFamily = FontFamily(Font(R.font.hand)),
                    modifier = Modifier.padding(end = 8.dp) // Space between text and image
                )
                Image(
                    painter = painterResource(id = R.drawable.kiss),
                    contentDescription = "小新",
                    alpha = 0.8f,
                    modifier = Modifier.clip(CircleShape).size(50.dp) // Specifying size
                )
            }

            Image(
                painter = painterResource(id = R.drawable.shock),
                contentDescription = "媽媽咪呀",
                alpha = 0.7f,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp) // Specifying size for background image
                    .padding(top = 32.dp) // Space from the other components
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}