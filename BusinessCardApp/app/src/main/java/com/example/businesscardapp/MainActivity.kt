package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp), // Add padding to the whole column
                        verticalArrangement = Arrangement.Top // Place items at the top
                    ) {
                        GreetingImage(
                            modifier = Modifier.fillMaxSize()
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Greeting(
                            name = "Joshua George",
                            about = "Student at Fremd High School",
                            modifier = Modifier.padding(16.dp)
                        )
                        Socials(
                            mail = "joshuageorge9@gmail.com",
                            phone = "847-737-2921",
                            github = "https://github.com/joshua-george",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.josh)
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Greeting(name: String, about: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center, // Center text vertically
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 38.sp,
            lineHeight = 64.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = about,
            fontSize = 20.sp,
            lineHeight = 64.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Socials(mail: String, phone: String, github: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center, // Center text vertically
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = mail,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = phone,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = github,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Column(modifier = Modifier.padding(16.dp)) { // Added padding to the preview column
            GreetingImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Greeting(
                name = "Joshua George",
                about = "Student at Fremd High School",
                modifier = Modifier.padding(16.dp)
            )
            Socials(
                mail = "joshuageorge9@gmail.com",
                phone = "847-737-2921",
                github = "https://github.com/joshua-george",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}