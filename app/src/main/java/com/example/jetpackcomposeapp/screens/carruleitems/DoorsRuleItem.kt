package com.example.jetpackcomposeapp.screens.carruleitems

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeapp.R
import com.example.jetpackcomposeapp.ui.theme.primaryCremea


//Item for controlling doors state
@Composable
fun DoorsRuleItem(
    isLockingButton: Boolean,// if this is lock button
    isLoading: Boolean, // if loading is showing
    isEnabled: Boolean, // if this button enable
    isCurrentState: Boolean, // if this is doors' current state
    isClickable: Boolean, // if clickable (false if showing loading)
    modifier: Modifier, //
    onClick: (Boolean) -> Unit,
) {
    //for getting button pressed state
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    //set button appearance depends on Doors' opening state
    val color =
        if (isPressed || isEnabled) Color.DarkGray else if (isCurrentState) primaryCremea else Color.Black

    val tint = if (isPressed || isEnabled) Color.LightGray else Color.White
    val size = if (isPressed && isClickable) 50.dp else 60.dp
    val icon = if (isLockingButton) R.drawable.ic_lock else R.drawable.ic_unlock

    //if loading is showing add progress bar else add button
    if (isLoading) {
        CircularProgressIndicator(modifier.size(size), color = primaryCremea)
    } else {
        Button(
            onClick = {
                if (isClickable) {
                    onClick(isLockingButton)
                }
            },
            interactionSource = interactionSource,
            modifier = modifier.size(size),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(contentColor = tint, backgroundColor = color)
        ) {
            Icon(
                painter = painterResource(icon), contentDescription = "Lock", tint = tint
            )
        }
    }
}
