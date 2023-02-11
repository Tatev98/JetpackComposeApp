package com.example.jetpackcomposeapp.components.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.ui.theme.primaryCremea

@Composable
fun DotsIndicator(
    modifier: Modifier,
    totalDots: Int,
    selectedIndex: Int
) {
    LazyRow(
        modifier = modifier
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(25.dp, 3.dp)
                        .clip(RectangleShape)
                        .background(primaryCremea)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(25.dp, 3.dp)
                        .clip(RectangleShape)
                        .background(Color.LightGray)
                )
            }
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
        }
    }
}