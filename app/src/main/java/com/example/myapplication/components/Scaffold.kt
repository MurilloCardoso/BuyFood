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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(onNavigateToFriends: () -> Unit, body: @Composable () -> Unit) {
    Scaffold(
        bottomBar = { BottomAppBarWithIconAndText(onNavigateToFriends) },
        //topBar = { TopAppBarWithIconAndText(onNavigateToFriends) }
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
fun TopAppBarWithIconAndText() {

    TopAppBar(actions = {
        IconButton(onClick = { /* do something */ }) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Localized description"
            )
        }
    }, title = {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("Bem-vindo",color= colorResource(id = R.color.DarkGreen), fontWeight = FontWeight.SemiBold)
        }
    })


}

@Composable
fun BottomAppBarWithIconAndText(onNavigateToFriends: () -> Unit) {

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
                    .clickable(onClick = onNavigateToFriends)
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
                    .clickable(onClick = onNavigateToFriends)
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
                    .clickable(onClick = onNavigateToFriends)
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

