package com.example.jetpackcomposeapp.events

sealed class DoorsStateEvent {
    object Locked : DoorsStateEvent()
    object Unlocked : DoorsStateEvent()
}
