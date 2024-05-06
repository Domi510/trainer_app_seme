package com.example.trainer_app_prototype.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _uiState = MutableLiveData(LoginUIState())
    val uiState: LiveData<LoginUIState> = _uiState

    fun updateUsername(username: String) {
        _uiState.value = uiState.value?.copy(username = username)
    }

    fun updatePassword(password: String) {
        _uiState.value = uiState.value?.copy(password = password)
    }

    fun login() {
        if (uiState.value?.username.isNullOrEmpty() || uiState.value?.password.isNullOrEmpty()) {
            _uiState.value = uiState.value?.copy(errorMessage = "Username and password cannot be empty.")
        }
        // Continue with login logic
    }
}