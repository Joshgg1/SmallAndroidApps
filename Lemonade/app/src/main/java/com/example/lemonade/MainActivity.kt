package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                }
            }
        }
    }
}

@Composable
fun LemApp(name: String, modifier: Modifier = Modifier) {
    LemRunner(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Preview(showBackground = true)
@Composable
fun LemRunner(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree // Default to lemon tree
    }
    val textResource = when (result) {
        1 -> R.string.lemonTree
        2 -> R.string.Lemon
        3 -> R.string.lemGlass
        4 -> R.string.emGlass
        else -> R.string.lemonTree // Default to lemon tree text
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = textResource)) // Display text based on state
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                when (result) {
                    1 -> result = 2
                    2 -> {
                        squeezeCount++
                        if (squeezeCount >= 2) {
                            result = 3
                            squeezeCount = 0 // Reset squeeze count
                        }
                    }
                    3 -> result = 4
                    4 -> result = 1
                }
            },
        ) {
            Text(text = stringResource(R.string.next), fontSize = 24.sp)
        }
    }
}