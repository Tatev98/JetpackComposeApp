package com.example.jetpackcomposeapp.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapp.data.local.HomeRepository
import com.example.jetpackcomposeapp.events.DoorsStateEvent
import com.example.jetpackcomposeapp.events.UIEvent
import com.example.jetpackcomposeapp.events.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {


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

            //set doors corresponding state to local datastore
            setCarDoorsLocked(isLocked)

            //emit doors state change
            if (isLocked) {
                doorsStateChangeEvent.emit(DoorsStateEvent.Locked)
            } else {
                doorsStateChangeEvent.emit(DoorsStateEvent.Unlocked)
            }
        }
    }


    //get car name from repository and create stateflow
    val carName: StateFlow<String> = homeRepository.carName().filter {
        it.isNotEmpty()
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            "QX55"
        )

    //set new car name
    private fun setCarName(name: String) {
        viewModelScope.launch {
            homeRepository.setCarName(name)
        }
    }


    //get car miles from repository and create stateflow
    val carMiles: StateFlow<Int> = homeRepository.carMiles()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            120
        )

    //set  car miles
    private fun setCarMiles(miles: Int) {
        viewModelScope.launch {
            homeRepository.setCarMiles(miles)
        }
    }

    //get car doors' state from repository and create stateflow
    val carDoorsLocked: StateFlow<Boolean> = homeRepository.carDoorsState()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            true
        )


    //change car doors' state
    private fun setCarDoorsLocked(locked: Boolean) {
        viewModelScope.launch {
            homeRepository.setCarDoorsState(locked)
        }
    }

    companion object {
        // time in ms for showing loading
        private const val DELAY_SHOW_LOADING = 5000L
    }
}



