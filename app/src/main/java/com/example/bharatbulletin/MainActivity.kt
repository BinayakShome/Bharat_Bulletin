package com.example.bharatbulletin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.bharatbulletin.Screens.AboutDevelopersScreen
import com.example.bharatbulletin.Screens.HomeScreen
import com.example.bharatbulletin.Screens.LiveNews
import com.example.bharatbulletin.Screens.NewsDisplayScreen
import com.example.bharatbulletin.ViewModel.HomeScreenViewModel
import com.example.bharatbulletin.navigation.DevPage
import com.example.bharatbulletin.navigation.HomePage
import com.example.bharatbulletin.navigation.LivePage
import com.example.bharatbulletin.navigation.NewsDisplayPage
import com.example.bharatbulletin.ui.theme.BharatBulletinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val homeViewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]
        setContent {

            val navController = rememberNavController()

            BharatBulletinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color(0xFFF8F8F8))
                            .padding(vertical = 15.dp)
                    ) {
                        Text(
                            text = "Bharat Bulletin",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(bottom = 15.dp),
                            fontSize = 25.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        NavHost(navController = navController, startDestination = HomePage) {
                            composable<HomePage> { HomeScreen(homeViewModel, navController) }
                            composable<NewsDisplayPage> {
                                val args = it.toRoute<NewsDisplayPage>()
                                NewsDisplayScreen(args.url)
                            }
                            composable<LivePage> { LiveNews(navController) }
                            composable<DevPage> { AboutDevelopersScreen(navController) }
                        }
                    }
                }
            }
        }
    }
}