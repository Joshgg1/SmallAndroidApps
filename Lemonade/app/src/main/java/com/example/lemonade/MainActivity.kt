package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }


}
@Composable
fun LemonApp() {
    var step by remember { mutableStateOf(1) }
    var tapCount by remember { mutableStateOf((2..4).random()) }
    var currentTapCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (step) {
            1 -> {
                LemonStep(
                    imageId = R.drawable.lemon_tree,
                    textId = R.string.tapSelect,
                    contentDescriptionId = R.string.lemonTree,
                    onClick = {
                        step = 2
                        tapCount = (2..4).random()
                        currentTapCount = 0
                    }
                )
            }
            // Add other steps logic here when needed
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Your Button, after the LemonStep
        Button(onClick = { /*TODO*/ }) {
            Text(stringResource(R.string.roll))
        }
    }
}

@Composable
fun LemonStep(
    imageId: Int,
    textId: Int,
    contentDescriptionId: Int,
    onClick: () -> Unit
) {
    Text(text = stringResource(id = textId), modifier = Modifier.padding(16.dp))
    Spacer(modifier = Modifier.height(16.dp))
    Image(
        painter = painterResource(id = imageId),
        contentDescription = stringResource(id = contentDescriptionId),
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .clickable { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}


