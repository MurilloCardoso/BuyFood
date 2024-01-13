package com.example.myapplication.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.FoodScreen
import com.example.myapplication.R
import com.example.myapplication.ui.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample( navController: NavHostController , body: @Composable () -> Unit  ) {
    Scaffold(
        bottomBar = { BottomAppBarWithIconAndText(navController) },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            body()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldAdd( navController: NavHostController , body: @Composable () -> Unit, catalog:ItemCatalog) {
    Scaffold(
        bottomBar = { BottomAppBarWithButton(navController,catalog) },
        topBar = { CupcakeAppBar("" ,canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })}
        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            body()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
    currentScreen: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { if(currentScreen.isNotEmpty()){ Text(currentScreen)} },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = primary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Composable
fun BottomAppBarWithButton(navController: NavHostController,catalog:ItemCatalog) {

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(start = 15.dp, end = 15.dp),

        ) {
           Button(shape = MaterialTheme.shapes.medium,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp)
               ,
               onClick = { /*TODO*/ }) {
               Text("Add to Cart ("+catalog.price+")")
           }}

        }

}
@Composable
fun BottomAppBarWithIconAndText(navController: NavHostController) {

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .clickable(onClick = {
                        navController.navigate("home") {
                            launchSingleTop = true
                        }
                    })
                    .weight(1f)
                    .fillMaxHeight(),
                // ajuste o espaçamento conforme necessário
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(28.dp) // Ajuste o tamanho do ícone
                )
                Spacer(modifier = Modifier.height(1.dp)) // Adicione um Spacer
                Text(
                    text = "Home",
                    fontSize = 12.sp
                )
            }

            Column(
                Modifier
                    .clickable(onClick = {
                        navController.navigate("menu") {
                            launchSingleTop = true
                        }
                    })
                    .weight(1f)
                    .fillMaxHeight(),
                // ajuste o espaçamento conforme necessário
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_restaurant_menu_24),
                    contentDescription = "Menu",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Menu",
                    fontSize = 12.sp
                )

            }
            Column(
                Modifier
                    .clickable(onClick = {
                        navController.navigate("cart") {
                            launchSingleTop = true
                        }
                    })
                    .weight(1f)
                    .fillMaxHeight(),
                // ajuste o espaçamento conforme necessário
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(

                    contentDescription = "Cart",
                    imageVector = Icons.Filled.ShoppingCart,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Cart",
                    fontSize = 12.sp
                )

            }
        }
    }
}

