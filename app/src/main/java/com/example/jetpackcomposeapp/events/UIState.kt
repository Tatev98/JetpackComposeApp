package com.example.jetpackcomposeapp.events

//State to show needed state of view
data class UIState(
    val isDoorsLocked: Boolean = true, // doors' locked state (default are locked)
    val isShowingLoading: Boolean = false, // loading showing state
    val updatedDate: Long = 0L, // updated time
    val isShowingDialog: Boolean = false, //alert dialog showing state
    val isClickedLock: Boolean = false // buttons click state (lock/true) (unlocked/false)
)