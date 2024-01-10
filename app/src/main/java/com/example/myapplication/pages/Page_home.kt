package com.example.myapplication.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button

import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.components.CardShop
import com.example.myapplication.components.FilledCardExample
import com.example.myapplication.components.ItemCatalog
import com.example.myapplication.components.ItemShopView
import com.example.myapplication.components.SimpleOutlinedTextFieldSample

import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController){
    val state = rememberScrollState()



        Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
        ) {

                BodyContent(navController)

        }
        }
//        Column(
//            modifier = Modifier
//                .padding(innerPadding),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//
//        ) {
//            BodyContent()
//        }

}


@Composable
fun BodyContent(navController: NavHostController) {

    val catalogData = listOf(
        ItemCatalog("Sushi", R.drawable.sushi,55.0,"Sushi"),
        ItemCatalog("Hamburguer", R.drawable.hamburguer,30.0,"Hamburguer"),
        ItemCatalog("Almoço", R.drawable.almoco,20.0,"Almoço"),
        ItemCatalog("Açai", R.drawable.acai,18.50,"Açai")
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),

        modifier =Modifier.padding(16.dp)
    ) {

        Divider()
        Text(
            text = "Melhores da semana",
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,

            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)

        )


        LazyRow {
            items(catalogData) { item ->
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    ItemShopView(item,  navController)
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Divider()

        Text(
            text = "Você adorou",
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,

            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)

        )

        LazyRow {
            items(catalogData) { item ->
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    ItemShopView(item, navController)
                }
            }
        }
//        LazyColumn {
//            items(catalogData) { item ->
//
//                CardShop()
//            }
//        }
    }

}