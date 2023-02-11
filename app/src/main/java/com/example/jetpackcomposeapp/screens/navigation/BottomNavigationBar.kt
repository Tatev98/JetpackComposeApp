package com.example.jetpackcomposeapp.screens.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcomposeapp.navigation.NavigationItem
import com.example.jetpackcomposeapp.ui.theme.primaryCremea
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home, NavigationItem.Vehicle, NavigationItem.Location, NavigationItem.More
    )
    BottomNavigation(
        backgroundColor = Color.White, contentColor = Color.Black, elevation = 20.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .background(Color.Transparent)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            items.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }

    }
}


//create navigation bar item
@Composable
fun AddItem(
    screen: NavigationItem, currentDestination: NavDestination?, navController: NavController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val contentColor = if (selected) primaryCremea else Color.Black

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Surface(color = Color.White) {
            ConstraintLayout(
                modifier = Modifier.wrapContentWidth()
            ) {
                val (topLine, icon, text) = createRefs()
                Surface(color = if (selected) primaryCremea else Color.White,
                    modifier = Modifier
                        .height(2.dp)
                        .width(70.dp)
                        .constrainAs(topLine) {
                            top.linkTo(parent.top)
                        }) {}
                Icon(painter = painterResource(screen.icon),
                    contentDescription = screen.title,
                    tint = contentColor,
                    modifier = Modifier
                        .padding(4.dp)
                        .constrainAs(icon) {
                            top.linkTo(topLine.bottom)
                            bottom.linkTo(text.top)
                            start.linkTo(topLine.start)
                            end.linkTo(topLine.end)
                            width = Dimension.wrapContent
                        })
                Text(text = screen.title,
                    color = contentColor,
                    style = MaterialTheme.typography.body2.merge(),
                    modifier = Modifier
                        .padding(4.dp, 0.dp, 4.dp, 8.dp)
                        .constrainAs(text) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(topLine.start)
                            end.linkTo(topLine.end)
                            width = Dimension.wrapContent
                        })
            }
        }
    }
}

