package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.components.CupcakeAppBar
import com.example.myapplication.components.ItemCatalog
import com.example.myapplication.components.ScaffoldAdd
import com.example.myapplication.components.ScaffoldExample
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.pages.HomePage
import com.example.myapplication.pages.MenuPage
import com.example.myapplication.pages.ScrollBoxesSmooth
import com.example.myapplication.pages.pageBuy

enum class FoodScreen(@StringRes val title: Int) {
    Home(title = R.string.route_home),
    Menu(title = R.string.route_menu),
    Cart(title = R.string.route_cart),
    Buy(title = R.string.route_buy)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyApplicationTheme {
                MyAppNavHost()
            }
        }
    }
}

data class Message(val author: String, val body: String)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppNavHost(




) {
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = FoodScreen.valueOf(
        backStackEntry?.destination?.route ?: FoodScreen.Home.name
    )

    Scaffold(
        topBar = {
            CupcakeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(

            navController = navController,
            startDestination = FoodScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
            ) {
            composable(route =FoodScreen.Home.name) {
                ScaffoldExample(navController = navController) { HomePage(navController) }
            }
            composable(route= FoodScreen.Menu.name) { ScaffoldExample(navController) { MenuPage() } }
            composable(route= FoodScreen.Buy.name) { pageBuy(navController, ItemCatalog("Açai", R.drawable.acai,18.50,"Açai")) }
        }
    }
}

@Composable
fun ProfileScreen(
    onNavigateToFriends: () -> Unit,
    /*...*/
) {
    /*...*/
    Button(onClick = onNavigateToFriends) {
        Text(text = "See friends list")
    }
}
@Composable
fun MessageCard(msg: com.example.myapplication.Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.sailor_moon),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))


        }
    }

}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = false,
    name = "Light Mode"
)
@Composable
fun PreviewMessageCard() {
    MyApplicationTheme {
            MessageCard(
                msg = Message("Colleague", "Take a look at Jetpack Compose, it's great!")
            )
    }
}