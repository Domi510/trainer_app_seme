package com.example.trainer_app_prototype.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainer_app_prototype.states.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state: StateFlow<RegisterState> = _state
    val showDialog = mutableStateOf(false)
    val userRole = mutableStateOf("")

    fun updateName(name: String) {
        _state.value = _state.value.copy(name = name)
    }

    fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun updatePhoneNumber(phoneNumber: String) {
        _state.value = _state.value.copy(phoneNumber = phoneNumber)
    }

    fun register() {
        // Here you would trigger the registration logic
        // For now, it just logs or can be used to simulate registration
        println("Registering: ${_state.value}")
        showDialog.value = true
    }

    fun handleRoleSelection(role: String) {
        userRole.value = role
        showDialog.value = false
        // Further logic can be implemented here such as updating the database or navigating
        println("Selected role: $role")
    }
}