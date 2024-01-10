package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R


@Composable
fun ItemShopView(item: ItemCatalog,navController: NavHostController) {

     Column(

        ) {
            val imageModifier = Modifier
                .size(width = 120.dp, height = 150.dp)
                .clip(RoundedCornerShape(20.dp)).clickable { navController.navigate("buy") }

            // Conteúdo do Card
            Image(
                painter = painterResource(id = item.image),
                contentDescription =  item.descrition,
                contentScale = ContentScale.FillBounds,
                modifier = imageModifier
            )
            Text(
                text = item.itemName,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 5.dp, bottom = 3.dp)
            )
            Text(
                    text = "R$"+item.price,
                color = colorResource(id = R.color.DarkGreen) , fontWeight = FontWeight.Bold ,
              )
        }
        // Text sobreposto ao Card
}