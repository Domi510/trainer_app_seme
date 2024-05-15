package com.codecx.composeui.sealclasses

sealed class AuthStates {
    data object Init : AuthStates()
    data object Success : AuthStates()
    data class Fail(val message: String) : AuthStates()
    data class Loading(val message: String) : AuthStates()
}