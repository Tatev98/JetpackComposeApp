package com.example.jetpackcomposeapp.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposeapp.ui.theme.primaryBlue


//Show usual alert dialog with 2 buttons
@Composable
fun DefaultAlert(
    title: String,
    text: String,
    confirmBtnText: String,
    cancelBtnText: String,
    onDismiss: (Boolean) -> Unit //set onDismiss value true if clicked confirm btn else set false
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss(false)
        },
        title = {
            Text(text = title, color = Color.Black)
        },
        text = {
            Text(
                text,
                color = Color.Black
            )
        },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = primaryBlue),
                onClick = {
                    onDismiss(true)
                },
            ) {
                Text(confirmBtnText, color = Color.White)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss(false)
                }) {
                Text(cancelBtnText, color = primaryBlue)
            }
        }
    )
}