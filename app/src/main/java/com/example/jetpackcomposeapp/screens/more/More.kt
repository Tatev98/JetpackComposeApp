package com.example.jetpackcomposeapp.screens.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeapp.ui.theme.primaryGray
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun MoreScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryGray)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "More"
        )
    }
}