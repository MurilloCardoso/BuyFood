package com.example.myapplication.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
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
import androidx.compose.ui.graphics.Brush
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
import com.example.myapplication.components.BottomAppBarWithButton
import com.example.myapplication.components.FilledCardExample
import com.example.myapplication.components.ItemCatalog
import com.example.myapplication.components.ScaffoldAdd
import com.example.myapplication.components.addPlus


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageCart(navController: NavHostController, catalog: ItemCatalog) {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                containerColor = Color.Transparent
            ) {
                Row(
                    modifier = Modifier.padding(start = 10.dp,end=10.dp),

                    ) {

                    Button( shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .fillMaxWidth().height(50.dp)
                           ,
                        onClick = { /*TODO*/ }) {
                        Text("Finalizar pedido", fontWeight = FontWeight.Bold, fontSize =  16.sp)
                    }

                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            BodyContentCart(navController, catalog)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyContentCart(navController: NavHostController, catalog: ItemCatalog) {
    // Smoothly scroll 100px on first composition

  val  listColors = listOf(Color.White, Color.DarkGray, Color.Black)
    val isFinished: Boolean = true
    Surface() {

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()  // Adiciona este modifier para ocupar toda a altura da tela
                .verticalScroll(rememberScrollState())
                .background(color = colorResource(id = R.color.grey))
        ) {
            if (isFinished) {
                Column(  ) {
                    ListItem(
                        headlineText = { Column(){
                            Text(text= catalog.itemName.toString(), fontWeight = FontWeight.Bold)
                            Text(text="R$"+catalog.price.toString(),color= colorResource(id = R.color.DarkGreen))
                        }},
                        trailingContent = { addPlus() },
                        leadingContent = {
                            Card(shape = RoundedCornerShape(12.dp)){
                            Image(
                                painter = painterResource(id = R.drawable.hamburguer),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),   contentScale = ContentScale.FillBounds,

                            )
                            }
                        },
                    )
                    Divider()

                }
            }
           Column(
               Modifier
                   .fillMaxSize()
                   .background(color = colorResource(id = R.color.white))

           ) {
               ListItem(modifier = Modifier.height(50.dp),
                   headlineText = { Text("Subtotal") },
                   trailingContent = { Text("R$"+catalog.price.toString()) },
               )
               Divider()
               ListItem(modifier = Modifier.height(50.dp),
                   headlineText = { Text("Taxa de entrega") },

                   trailingContent = { Text("R$"+catalog.price.toString()) },
               )
               Divider()
               ListItem(
                   modifier = Modifier.height(50.dp),
                   headlineText = { Text("Total", fontWeight = FontWeight.Bold,fontSize =  18.sp ) },
                   trailingContent = { Text("R$"+catalog.price.toString(), fontWeight = FontWeight.ExtraBold, fontSize =  18.sp ) },
               )
           }
        }
    }
}

