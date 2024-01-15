package com.example.myapplication.pages

import android.content.Context
import androidx.compose.ui.platform.LocalContext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.myapplication.components.PreferencesManager


fun PageLogin(){


}
@Composable
fun MyComposableFunction() {
    val context: Context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getData("myKey", "")) }

    // Use the data variable in your Composable

    // Update data and save to SharedPreferences
    preferencesManager.saveData("myKey", "newDataValue")
    data.value = "newDataValue"
}