package com.example.bharatbulletin.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.bharatbulletin.ViewModel.HomeScreenViewModel
import com.example.bharatbulletin.navigation.LivePage
import com.kwabenaberko.newsapilib.models.Article

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel, navController: NavHostController) {

    //val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val articles by homeScreenViewModel.articles.observeAsState(emptyList())
    val errorMessage by homeScreenViewModel.errorMessage.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
        //.padding(WindowInsets.systemBars.asPaddingValues()) // Ensures padding for system bars
        //.background(Color(0xFFF8F8F8)) // Light background color
    ) {
        Category(homeScreenViewModel, navController)

        if (errorMessage != null && errorMessage!!.isNotEmpty()) {
            Text(text = errorMessage ?: "",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 100.dp, bottom = 20.dp))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(articles.filter { it.title != "[Removed]" }) { article ->
//            Text(text = article.title,
//                color = Color.Black)
//            //Text(text = article.title)
                    articleItem(article = article, navController)
                }
            }
        }
    }
}

@Composable
fun articleItem(article: Article, navController: NavHostController)
{
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 6.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 4.dp),
        onClick = {
            navController.navigate(com.example.bharatbulletin.navigation.NewsDisplayPage(article.url))
        }
    ) {
     Row(
         modifier = Modifier
             .fillMaxWidth()
             .background(Color(0xFFF8F8FF)) //Ghost White
             .padding(horizontal = 7.dp, vertical = 5.dp),
         verticalAlignment = Alignment.CenterVertically
     ) {
         AsyncImage(model = article.urlToImage?:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSh8IRIwhipevKFBLVl5rEwvOb750rFb7eSw&s",
             contentDescription = "News Image",
             modifier = Modifier
                 .size(90.dp)
                 .aspectRatio(1f),
             contentScale = ContentScale.Crop)

         Column(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(8.dp)
         ) {
                Text(text = article.title,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3)
             Text(text = article.source.name,
                 fontSize = 12.sp,
                 color = Color.Black,
                 maxLines = 1)
//             Text(text = article.publishedAt,
//                 fontSize = 12.sp)  --> This can add the date and time
         }
     }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Category(homeScreenViewModel: HomeScreenViewModel, navController: NavHostController) {
    var searchquery by remember { mutableStateOf("") }
    var searchexpanded by remember { mutableStateOf(false) }
    val categoryList = listOf(
        "GENERAL",
        "TECHNOLOGY",
        "BUSINESS",
        "ENTERTAINMENT",
        "HEALTH",
        "SCIENCE",
        "SPORTS"
    )

    var isButtonEnabled by remember { mutableStateOf(true) }
    var label by remember { mutableStateOf("Today's Top Headlines") } // Default label

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (searchexpanded) {
                OutlinedTextField(
                    value = searchquery,
                    onValueChange = { searchquery = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            if (searchquery.trim().isNotEmpty()) {
                                homeScreenViewModel.fetchEveryNews(searchquery.trim())
                            } else {
                                searchexpanded = false
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = Color.Black
                            )
                        }
                    },
                    shape = RoundedCornerShape(36.dp),
                    textStyle = TextStyle(color = Color.Black, fontSize = 13.sp),
                    modifier = Modifier
                        .height(47.dp)
                        .padding(start = 10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Border color when focused
                        unfocusedBorderColor = Color.Gray
                    ),
                    maxLines = 1,
                    singleLine = true
                )
            } else {
                IconButton(onClick = { searchexpanded = true }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 10.dp)
                    )
                }
            }

            categoryList.forEach { category ->
                Button(
                    onClick = {
                        homeScreenViewModel.fetchNewsTopHeadlines(category)
                        label = "${category.lowercase().replaceFirstChar { it.uppercase() }}" // Update label on click
                    },
                    modifier = Modifier.padding(horizontal = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        if (isButtonEnabled) Color(0xFF2196F3) else Color.Red
                    ),
                    enabled = isButtonEnabled
                ) {
                    Text(text = category, color = Color.White)
                }
            }

            Button(
                onClick = { navController.navigate(LivePage) },
                modifier = Modifier.padding(horizontal = 4.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
            ) {
                Text(text = "Live News", color = Color.White)
            }
        }

        // Display the label below the Row
        if (label == "General") {
            Text(text = "Today's Top Headlines",
                modifier = Modifier.padding(top = 16.dp, start = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold)
            )
        } else {
            Text(
                text = label,
                modifier = Modifier.padding(top = 16.dp, start = 10.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
