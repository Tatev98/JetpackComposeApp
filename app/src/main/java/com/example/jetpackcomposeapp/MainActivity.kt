package com.example.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.model.navigation.Navigation
import com.example.jetpackcomposeapp.screens.navigation.BottomNavigationBar
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen() {
    //create bottomNavBar

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.padding(bottom = 10.dp),
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier
                .padding(padding)
                .navigationBarsPadding()) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = Color.White
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeAppTheme {
        MainScreen()
    }
}