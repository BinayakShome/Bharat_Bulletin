package com.example.bharatbulletin.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bharatbulletin.R
import com.example.bharatbulletin.navigation.LivePage

@Composable
fun AboutDevelopersScreen(navController: NavController) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8FF)) // Light background color
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Profile Picture
        item {
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
                Button(
                    onClick = {navController.navigate(LivePage)},
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(text = "← Back",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)
                }

            }
            Card(
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.Gray),
                modifier = Modifier.size(120.dp)
            ) {
                AsyncImage(
                    model = R.drawable.dev,
                    contentDescription = "Developer Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            // Developer Name
            Text(
                text = "Binayak Shome",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            // Developer Role
            Text(
                text = "Developer",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }
        item {
            Spacer(modifier = Modifier.height(44.dp))
        }

        item {
            // About Section
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "About Developer",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Welcome to the News App, developed by Binayak Shome, a dedicated 2nd-year Computer Science undergraduate at KIIT, Bhubaneswar. This project reflects my commitment to delivering a high-quality news experience and helping users stay informed with the latest updates, trends, and breaking news from around the world.",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Our Vision",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This app is not just about reading the news — it's about making it easier for you to discover, explore, and stay connected with the latest headlines and updates. Every detail has been carefully designed to ensure a seamless user experience, with new features and updates coming soon to keep you engaged and informed.",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Thank You for Choosing Us!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "I'm grateful for the opportunity to share this project with you, and I truly hope it meets your expectations. Stay tuned for future updates, and feel free to share any feedback or suggestions to help improve the app.\n" +
                                "\n" +
                                "With Sincere Regards,\n" +
                                "Binayak Shome\n" +
                                "Developer, App Enthusiast,Computer Science Student",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(44.dp))
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Connect With Me",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(modifier = Modifier.fillMaxSize()) {
                    Row (modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
                        ContactCard(
                            imageUrl = "https://www.stickitup.xyz/cdn/shop/products/14_599074e1-fcf3-4f27-874a-aba7dfaf51bd.jpg?v=1622360246",
                            label = "Instagram", url = "https://www.instagram.com/binayakshome_06/", context = context
                        )
                        Spacer(modifier = Modifier.width(80.dp))
                        ContactCard(
                            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png",
                            label = "LinkedIn", url = "https://www.linkedin.com/in/binayak-shome-831b192b6/", context = context
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row (modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
                        ContactCard(
                            imageUrl = "https://e7.pngegg.com/pngimages/1000/19/png-clipart-github-logo-computer-icons-source-code-github-white-cat-like-mammal.png",
                            label = "Github  ",
                            url = "https://github.com/BinayakShome",
                            context = context
                        )
                        Spacer(modifier = Modifier.width(110.dp))
                        ContactCard(
                            imageUrl = "https://thumbs.dreamstime.com/b/social-media-267407657.jpg",
                            label = "Gmail",
                            url = "mailto:binayakshome3@gmail.com",
                            context = context
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row (modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Absolute.Center){
                        ContactCard(
                            imageUrl = "https://i.pinimg.com/736x/72/52/a7/7252a7a2b8fa3ab9bd2294b0edfe96ba.jpg",
                            label = "X",
                            url = "https://x.com/binayakshome06?t=fqDMGbWvYXhyT8kYvf_cCw&s=09",
                            context = context
                        )
                        Spacer(modifier = Modifier.width(150.dp))
                        ContactCard(
                            imageUrl = "https://png.pngtree.com/png-clipart/20190516/original/pngtree-whatsapp-icon-png-image_3584845.jpg",
                            label = "Whatsapp",
                            url = "https://wa.me/+918812989114",
                            context = context
                        )
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.height(30.dp)) }
        item {
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(36.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(36.dp)
                    )
                    .background(Color.Cyan),
                contentAlignment = Alignment.Center,
            ){
                Text(text = "Coded with ❤\uFE0F and ☕ by\nBinayak",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black)
            }
        }
    }
    }

@Composable
fun ContactCard(
    imageUrl: String,
    label: String,
    url: String,
    context: android.content.Context
) {
    Row(
        modifier = Modifier
            .background(Color(0xFFF8F8FF)) // Ghost White background
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = label,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp) // Proper size for the image
                .background(Color.LightGray) // Placeholder background
        )
        Spacer(modifier = Modifier.width(10.dp)) // Space between the image and the text
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
    }
}
