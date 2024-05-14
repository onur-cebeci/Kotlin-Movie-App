@file:OptIn(ExperimentalMaterial3Api::class)

package com.onurcebeci.movieapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.onurcebeci.movieapp.models.Data
import com.onurcebeci.movieapp.viewModel.MovieViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val movieViewModel = viewModel<MovieViewModel>()
    val state = movieViewModel.state


    Scaffold(
    modifier = Modifier.background(Color.Transparent),

    topBar = {
        TopBar()
    },
 content = {paddingValues -> LazyVerticalGrid(columns = GridCells.Fixed(2),
     Modifier
         .padding(paddingValues)
         .fillMaxSize()
         .background(Color.Transparent),
     content = {
         items(state.movies.size){
           ItemCard(itemIndex = it,movieList = state.movies,navController=navController)
         }
     }
     )
   },

        containerColor = Color.Transparent




)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemCard(itemIndex: Int, movieList: List<Data>, navController: NavHostController) {
    Card(
        Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clickable {

            },
    ){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){

            AsyncImage(model = movieList[itemIndex].poster, contentDescription =movieList[itemIndex].title,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,

                )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray.copy(.7f))
                    .padding(6.dp)
            ) {
                Text(text =movieList[itemIndex].title, modifier= Modifier
                    .fillMaxWidth()
                    .basicMarquee(),
                    textAlign = TextAlign.Center, color = Color.Black
                , fontWeight = FontWeight.Bold, maxLines = 1,
                    style = TextStyle(shadow = Shadow(
                        Color(0xFFFC6603),offset=Offset(1f,1f),3f)
                   ),
                )

                Spacer(modifier= Modifier.height(8.dp))


                Row(Modifier.align(Alignment.End)) {
                    Icon(imageVector = Icons.Rounded.Star, contentDescription ="")
                    Text(text = movieList[itemIndex].imdb_rating,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth().padding(start= 8.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 2
                        )

                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Movie App") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.White.copy(.4f)
        )
    )
}

