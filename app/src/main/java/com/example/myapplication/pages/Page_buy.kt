package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.components.CupcakeAppBar
import com.example.myapplication.components.FilledCardExample
import com.example.myapplication.components.ItemCatalog
import com.example.myapplication.components.ScaffoldAdd
import com.example.myapplication.components.addPlus


@Composable
fun pageBuy(navController: NavHostController, catalog:ItemCatalog){

    ScaffoldAdd(navController,{ScrollBoxesSmooth(navController,catalog)},catalog)
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBoxesSmooth(navController: NavHostController,catalog:ItemCatalog) {
    // Smoothly scroll 100px on first composition


    Surface {

        Column(
            modifier = Modifier

                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .height(200.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.burguerstore),
                    contentDescription = "a",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {


                Text(
                    text = "Texas Burguer",
                    color = Color.Black, fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 28.sp,
                    ),

                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Pão brioche, carne Angus 170g, queijo cheddar, bacon e maionese da casa. ",
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text(
                        text = "R$23.00",
                        color = colorResource(id = R.color.DarkGreen),
                        textAlign = TextAlign.Center,

                        style = TextStyle(
                            fontSize = 20.sp, fontWeight = FontWeight.Medium
                        ),
                    )
                    addPlus()

                }
                Text(
                    text = "Ingredientes",
                    color = Color.Black, fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 25.sp,

                        ),

                    textAlign = TextAlign.Center,
                )
                Column {
                    Text("" + catalog.itemName)
                }

            }
        }
    }
}
