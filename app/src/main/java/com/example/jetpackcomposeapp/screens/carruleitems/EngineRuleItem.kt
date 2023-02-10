package com.example.jetpackcomposeapp.screens.carruleitems

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


//Item for controlling engine state
@Composable
fun EngineRuleItem(
    text: String, modifier: Modifier
) {

    //for getting button pressed state
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()


    //change button appearance depends on pressed state
    val color = if (isPressed) Color.DarkGray else Color.Black
    val textColor = if (isPressed) Color.LightGray else Color.White
    val size = if (isPressed) 50.dp else 60.dp

    Button(
        onClick = {},
        interactionSource = interactionSource,
        modifier = modifier.size(size),
        shape = CircleShape,
        contentPadding = PaddingValues(2.dp),
        colors = ButtonDefaults.buttonColors(contentColor = textColor, backgroundColor = color)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h5.merge(),
            color = textColor,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
        )
    }
}