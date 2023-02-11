package com.example.jetpackcomposeapp.events.home

sealed class DoorsStateEvent {
    object Locked : DoorsStateEvent()
    object Unlocked : DoorsStateEvent()
}
