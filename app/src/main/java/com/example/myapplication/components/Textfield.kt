package com.example.myapplication.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.myapplication.R


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf(TextFieldValue()) }


    Box(
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "",
                    tint = colorResource(R.color.DarkGreen),
                    modifier = Modifier.clickable {
                    }
                )
            },

            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("Pesquisar") }
        )
    }
    }

