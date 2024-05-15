package com.codecx.composeui.repository

import com.codecx.composeui.models.User
import com.codecx.composeui.sealclasses.AuthStates
import kotlinx.coroutines.flow.Flow
/**
 * Rozhranie definuje funkcie,
 * ktoré musí implementovať akákoľvek trieda, ktorá sa rozhodne toto rozhranie použiť
 * */
interface FirebaseRepo {
    fun requestForLogin(email: String, password: String): Flow<AuthStates>
    fun requestForSignUp(user: User): Flow<AuthStates>
    fun loadAccountInfo(): Flow<AuthStates>
}