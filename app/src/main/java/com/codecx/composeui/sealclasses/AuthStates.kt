package com.codecx.composeui.sealclasses
/**
 * Trieda, ktorá môže nadobudnút iba nasledujúce stavy
 * Každý stav - môže prijať rôznu správu
 * */
sealed class AuthStates {
    data object Init : AuthStates()
    data object Success : AuthStates()
    data class Fail(val message: String) : AuthStates()
    data class Loading(val message: String) : AuthStates()
}