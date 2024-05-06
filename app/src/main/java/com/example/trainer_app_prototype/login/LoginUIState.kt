package com.example.trainer_app_prototype.login

data class LoginUIState(
    val username: String = "",
    val password: String = "",
    val errorMessage: String? = null
)