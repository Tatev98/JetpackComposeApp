package com.example.jetpackcomposeapp.events.home


//For communication between view and viewModel
sealed class UIEventHome {
    data class OpenDialogStateChanged(val showDialog: Boolean) :
        UIEventHome() // Call when dialog showing state changes

    data class OnDoorsStateChanged(val locked: Boolean) :
        UIEventHome() // Call when doors' locking state changed

    data class OnAskForDoorsStateChanged(val locking: Boolean) :
        UIEventHome() // Call when asks for  doors' locking state change
    object OnRefreshedPage : UIEventHome() // Call when refreshing home page
}
