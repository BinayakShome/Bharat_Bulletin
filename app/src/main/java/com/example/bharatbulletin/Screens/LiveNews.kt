package com.example.bharatbulletin.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bharatbulletin.navigation.DevPage
import com.example.bharatbulletin.navigation.HomePage

@Composable
fun LiveNews(navController: NavController)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ){
            IconButton(onClick = {navController.navigate(HomePage)}) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Home Screen",
                    tint = Color.Black)
            }
            IconButton(onClick = {navController.navigate(DevPage)}) {
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = "About Developer",
                    tint = Color.Black)
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(1)
            {
                ChannelCard(url = "https://indianprdistribution.com/wp-content/uploads/2024/09/Zee-News-Indian-PR-Distribution-IPRD.png", ChannelName = "Zee News", onClick = "https://youtube.com/@zeenews?si=dw7cpmSruq_woUbr")
                ChannelCard(url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSShdDyUiXauovuZb90_6n-Ve9sLhqlIcxorg&s", ChannelName = "Aaj Tak", onClick = "https://youtube.com/@aajtak?si=YK6Uhy1tE1VbQVWN")
                ChannelCard(url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOCfZJQt5UFeKs0tyXTu4unodPz7FZP0kaLw&s", ChannelName = "NDTV", onClick = "https://youtube.com/@ndtv?si=omMqhOlRT9n5fZ6Y")
                ChannelCard(url = "https://cdn.vectorstock.com/i/1000v/48/26/bbc-news-logo-with-red-background-vector-42974826.jpg", ChannelName = "BBC news", onClick = "https://youtube.com/@bbcnews?si=N6J2aph43D33rlpE")
                ChannelCard(url = "https://www.indiantelevision.com/sites/default/files/images/tv-images/2019/05/08/ddnational.jpg", ChannelName = "DD News", onClick = "https://youtube.com/@ddnews?si=tSZS741J4Gi4DVua")
                ChannelCard(url = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Republic_TV.svg/1200px-Republic_TV.svg.png", ChannelName = "Republic TV", onClick = "https://youtube.com/@republicworld?si=w9ZHOPKAg0ECq-nf")
                ChannelCard(url = "https://static.tnn.in/thumb/msid-99404003,thumbsize-13482,width-1280,height-720,resizemode-75/99404003.jpg", ChannelName = "Times Now India", onClick = "https://youtube.com/@timesnownavbharat?si=PZ2aBi7Csb7FPRvR")
                ChannelCard(url = "https://yt3.googleusercontent.com/ytc/AIdro_lm8zxUFpFusFm7pDYj7pXP4vLi6vW5GG0yCeu6MkQQ3A=s900-c-k-c0x00ffffff-no-rj", ChannelName = "BTN", onClick = "https://youtube.com/@btnbaraktelevisionnetwork2421?si=6LD3XDw_QTHeif2M")
                ChannelCard(url = "https://m.media-amazon.com/images/I/51VQsRfgzoL.png", ChannelName = "India TV", onClick = "https://youtube.com/@indiatv?si=4cyeJIEoGOgWnpdL")
                ChannelCard(url = "https://content.jdmagicbox.com/comp/cuttack/29/0671p671std529/catalogue/all-india-radio-buxibazar-cuttack-radio-broadcasting-services-cjdopnv2a0.jpg?clr=", ChannelName = "All India Radio", onClick = "https://youtube.com/@newsonairofficial?si=fIu6MDNLjzD00iDJ")
            }
        }
    }
}

@Composable
fun ChannelCard(url: String, ChannelName: String, onClick: String) //url -> image url, onClick -> youtube channel
{
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 6.dp),
        elevation = CardDefaults
            .cardElevation(defaultElevation = 4.dp),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(onClick))
            context.startActivity(intent)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF8F8FF)) //Ghost White
                .padding(horizontal = 7.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = url,
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
                Text(text = ChannelName,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,)
            }
        }
    }
}