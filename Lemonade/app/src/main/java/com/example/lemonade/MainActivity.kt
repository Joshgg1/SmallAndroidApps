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

    ) {
        // Centered title with yellow background at the top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFE082))
                .padding(vertical = 16.dp)
                ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lemonade",
                fontSize = 24.sp, // Adjust the font size as needed
                modifier = Modifier.align(Alignment.Center)

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Existing content below the title
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
                2 -> {
                    LemonStep(
                        imageId = R.drawable.lemon_squeeze,
                        textId = R.string.keepTapping,
                        contentDescriptionId = R.string.Lemon,
                        onClick = {
                            currentTapCount++
                            if (currentTapCount >= tapCount) {
                                step = 3
                            }
                        }
                    )
                }
                3 -> {
                    LemonStep(
                        imageId = R.drawable.lemon_drink,
                        textId = R.string.tapDrink,
                        contentDescriptionId = R.string.lemGlass,
                        onClick = {
                            step = 4
                        }
                    )
                }
                4 -> {
                    LemonStep(
                        imageId = R.drawable.lemon_restart,
                        textId = R.string.tapRestart,
                        contentDescriptionId = R.string.emGlass,
                        onClick = {
                            step = 1
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
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