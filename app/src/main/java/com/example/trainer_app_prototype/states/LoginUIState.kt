package com.example.trainer_app_prototype.states

data class LoginUIState(
    val username: String = "",
    val password: String = "",
    val errorMessage: String? = null
)