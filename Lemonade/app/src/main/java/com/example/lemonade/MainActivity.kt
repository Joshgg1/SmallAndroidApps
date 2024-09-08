package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                // Step 1: Tap the lemon tree to select a lemon
                LemonStep(
                    imageId = R.drawable.lemon_tree,
                    textId = R.string.tapSelect,
                    contentDescriptionId = R.string.lemonTree,
                    onClick = {
                        step = 2
                        tapCount = (2..4).random() // Generate random tap count between 2 and 4
                        currentTapCount = 0 // Reset the current taps
                    }
                )
            }
            2 -> {
                // Step 2: Tap the lemon to squeeze it
                LemonStep(
                    imageId = R.drawable.lemon_squeeze,
                    textId = R.string.keepTapping,
                    contentDescriptionId = R.string.Lemon,
                    onClick = {
                        currentTapCount++
                        if (currentTapCount >= tapCount) {
                            step = 3 // Move to the next step after enough taps
                        }
                    }
                )
            }
            3 -> {
                // Step 3: Tap the lemonade to drink it
                LemonStep(
                    imageId = R.drawable.lemon_drink,
                    textId = R.string.tapDrink,
                    contentDescriptionId = R.string.lemGlass,
                    onClick = {
                        step = 4 // Move to the empty glass step
                    }
                )
            }
            4 -> {
                // Step 4: Tap the empty glass to restart
                LemonStep(
                    imageId = R.drawable.lemon_restart,
                    textId = R.string.tapRestart,
                    contentDescriptionId = R.string.emGlass,
                    onClick = {
                        step = 1 // Restart
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun LemonStep(
    imageId: Int,
    textId: Int,
    contentDescriptionId: Int,
    onClick: () -> Unit
) {
    Text(
        text = stringResource(id = textId),
        fontSize = 18.sp,
        modifier = Modifier.padding(16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Image(
        painter = painterResource(id = imageId),
        contentDescription = stringResource(id = contentDescriptionId),
        modifier = Modifier
            .size(250.dp)
            // used chatGPT for ".clip"
            .clip(RoundedCornerShape(16.dp)) // Rounded corners for the image
            .background(Color(0xFFFFE082))
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
