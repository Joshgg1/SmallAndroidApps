package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
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
                            social = "joshg_0",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}
//@Composable
//fun extraStuff(modifier: Modifier = Modifier){
//
//    Icon(
//        Icons.Rounded.Email,
//        contentDescription = "Email",
//        modifier = Modifier.padding(top = 4.dp).scale(1.25f).padding(horizontal = 16.dp),
//    )
//}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.josh)

    Box(
        modifier = modifier,
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
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color(0xFF278F0D),
            text = name,
            fontSize = 38.sp,
            lineHeight = 64.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
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
fun Socials(mail: String, phone: String, social: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "Email",
                modifier = Modifier.padding(top = 4.dp).scale(1.25f).padding(horizontal = 16.dp),
            )
            Text(
                text = mail,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        Row {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "Localized description",
                modifier = Modifier.padding(top = 4.dp).scale(1.25f).padding(horizontal = 16.dp),
            )
            Text(
                text = phone,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        Row {
            Icon(
                Icons.Rounded.Person,
                contentDescription = "Localized description",
                modifier = Modifier.padding(top = 4.dp).scale(1.25f).padding(horizontal = 16.dp),
            )
            Text(
                text = social,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val customColor = Color(red = 100, green = 180, blue = 255)
    BusinessCardAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .background(customColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
                social = "joshg_0",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}