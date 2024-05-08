package com.example.trainer_app_prototype.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app_prototype.states.TrainerHomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrainerHomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(TrainerHomeState("Hello, Ivan.", 5, "8:30"))
    val state: StateFlow<TrainerHomeState> = _state
    val showDialog = mutableStateOf(false)

    init {
        fetchTrainingSessions()
    }

    private fun fetchTrainingSessions() {
        // Simulate an asynchronous data fetch with coroutine
        viewModelScope.launch {
            // Imagine this data comes from a repository
            _state.value = TrainerHomeState(
                greeting = "Hello, Ivan.",
                trainingSessionsCount = 5, // Fetch real data here
                startTime = "8:30"
            )
        }
    }

    fun changeState() {
        showDialog.value = false

    }
}