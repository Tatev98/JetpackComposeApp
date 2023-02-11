package com.example.jetpackcomposeapp.events


//For communication between view and viewModel
sealed class UIEvent {
    data class OpenDialogStateChanged(val showDialog: Boolean) :
        UIEvent() // Call when dialog showing state changes

    data class OnDoorsStateChanged(val locked: Boolean) :
        UIEvent() // Call when doors' locking state changed

    data class OnAskForDoorsStateChanged(val locking: Boolean) :
        UIEvent() // Call when asks for  doors' locking state change
    object OnRefreshedPage : UIEvent() // Call when refreshing home page
}
