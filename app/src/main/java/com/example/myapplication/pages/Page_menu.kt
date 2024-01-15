package com.example.myapplication.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.FoodScreen
import com.example.myapplication.R
import com.example.myapplication.components.CupcakeAppBar
import com.example.myapplication.components.FilledCardExample
import com.example.myapplication.components.ItemCatalog
import com.example.myapplication.components.ScaffoldExample
import com.example.myapplication.components.SimpleOutlinedTextFieldSample

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageMenu(navController: NavHostController){

            BodyContent()


}

@Composable
fun BodyContent() {

    val catalogData = listOf(
        ItemCatalog("Sushi", R.drawable.sushi,55.0,"Sushi"),
        ItemCatalog("Hamburguer", R.drawable.hamburguer,30.0,"Hamburguer"),
        ItemCatalog("Almoço", R.drawable.almoco,20.0,"Almoço"),
        ItemCatalog("Açai", R.drawable.acai,18.50,"Açai")
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),

        modifier = Modifier
            .padding(16.dp)
    ) {
        SimpleOutlinedTextFieldSample()
        Text(
            text = "Categorias",
            color = colorResource(id =R.color.black),
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,

            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)

        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                    .fillMaxSize()

        ) {
            items(catalogData) { item ->
                FilledCardExample(item,{} )
            }
        }
    }
}