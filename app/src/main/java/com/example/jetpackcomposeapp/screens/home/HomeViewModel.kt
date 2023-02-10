package com.example.jetpackcomposeapp.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapp.events.DoorsStateEvent
import com.example.jetpackcomposeapp.events.UIEvent
import com.example.jetpackcomposeapp.events.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {


    private var _uiState = mutableStateOf(UIState())
    val uiState: State<UIState> = _uiState

    val doorsStateChangeEvent = MutableSharedFlow<DoorsStateEvent>()

    //controlling state changes using events
    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.OnDoorsStateChanged -> {
                setDoorsStateChanged(event.locked)
            }
            is UIEvent.OpenDialogStateChanged -> {
                _uiState.value = _uiState.value.copy(
                    isShowingDialog = event.showDialog
                )
            }
            is UIEvent.OnAskForDoorsStateChanged -> {
                _uiState.value = _uiState.value.copy(
                    isClickedLock = event.locking
                )
            }
        }
    }


    //show loading and set corresponding doors state
    private fun setDoorsStateChanged(isLocked: Boolean) {
        viewModelScope.launch {
            //show loading 5 sec
            _uiState.value = _uiState.value.copy(
                isShowingLoading = true
            )
            delay(DELAY_SHOW_LOADING)
            _uiState.value = _uiState.value.copy(
                isShowingLoading = false
            )

            //set doors corresponding state
            _uiState.value = _uiState.value.copy(
                isDoorsLocked = isLocked
            )
            //emit doors state change
            if (isLocked) {
                doorsStateChangeEvent.emit(DoorsStateEvent.Locked)
            } else {
                doorsStateChangeEvent.emit(DoorsStateEvent.Unlocked)
            }
        }
    }

    companion object {
        // time in ms for showing loading
        private const val DELAY_SHOW_LOADING = 5000L
    }
}