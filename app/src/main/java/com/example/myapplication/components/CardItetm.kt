package com.example.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

data class ItemCatalog(val itemName: String, val image: Int,val price:Double,val descrition:String)

@Composable
fun FilledCardExample(item: ItemCatalog, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .size(width = 250.dp, height = 150.dp)
                .clickable(onClick = onClick)
            //.clickable { onClick() } // Adicione esta linha se você quiser tornar o Box clicável
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .size(width = 250.dp, height = 150.dp)
        ) {
            val imageModifier = Modifier
                .size(width = 250.dp, height = 180.dp)

            // Conteúdo do Card
            Image(
                painter = painterResource(id = R.drawable.hamburguer),
                contentDescription = stringResource(id = R.string.app_name),
                contentScale = ContentScale.FillBounds,
                modifier = imageModifier
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray.copy(alpha = 0.3f),  shape = MaterialTheme.shapes.medium ) // Altere o valor alpha conforme necessário
        )
        // Text sobreposto ao Card
        Text(
            text = "Hamburguer",
            color = Color.White, fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 20.sp,
                shadow = Shadow(
                    color = Color.Black, offset =Offset(1.0f, 5.0f), blurRadius =40f
                )
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Color.Transparent)
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }

}