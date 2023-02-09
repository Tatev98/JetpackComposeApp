package com.example.jetpackcomposeapp.events


//For communication between view and viewModel
sealed class UIEvent {
    object LockedClicked : UIEvent() // Call when clicked on lock button
    object UnlockedClicked : UIEvent() // Call when clicked on unlock button
    data class OpenDialogStateChanged(val showDialog: Boolean) :
        UIEvent() // Call when dialog showing state changes

    data class OpenSnackbarStateChanged(val showSnackbar: Boolean) :
        UIEvent() // Call when snackbar showing state changes

    data class OpenDoorsStateChanged(val locked: Boolean) :
        UIEvent() // Call when doors' locking state changes
}
