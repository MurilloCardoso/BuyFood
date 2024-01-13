package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
@Preview
@Composable
fun addPlus(){

    Row(


        verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.border(
                    border = ButtonDefaults.outlinedButtonBorder,
        shape = RoundedCornerShape(10.dp)
    ),

        ) {

        IconButton(

            onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_horizontal_rule_24),
                contentDescription = "Menu",
                modifier = Modifier.size(18.dp)

            )
        }

        Text(
            text = "1", textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp,

                ),
        )
        IconButton(

            onClick = { /*TODO*/ })
        {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Menu",
                modifier = Modifier.size(18.dp))
        }
    }


}
