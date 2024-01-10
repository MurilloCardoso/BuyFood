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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollBoxesSmooth(navController: NavHostController) {
    // Smoothly scroll 100px on first composition
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

        Surface {

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .verticalScroll(state)
    ) {
        Box( modifier = Modifier
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

                Column(     modifier = Modifier.align(alignment = Alignment.BottomStart).padding(start = 15.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = painterResource(R.drawable.sailor_moon),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
                        )
                        Text(
                            text = "Texas Burguer",
                            color = Color.White, fontWeight = FontWeight.Bold,
                            style = TextStyle(
                                fontSize = 28.sp,
                                shadow = Shadow(
                                    color = Color.Black, offset = Offset(1.0f, 5.0f), blurRadius =40f
                                )
                            ),
                            modifier = Modifier

                                .background(Color.Transparent)
                                .padding(16.dp),
                            textAlign = TextAlign.Center,
                        )
                    }



                Row( verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        modifier = Modifier.size(28.dp) // Ajuste o tamanho do ícone
                    )
                    Text(
                        text = "5.5",
                        color = Color.White, fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            fontSize = 20.sp,
                            shadow = Shadow(
                                color = Color.Black, offset = Offset(1.0f, 5.0f), blurRadius =40f
                            )
                        ),
                        modifier = Modifier

                            .background(Color.Transparent)
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
                }

                }

        }
    }
    }

}