package com.codecx.composeui.repository

import com.codecx.composeui.models.User
import com.codecx.composeui.sealclasses.AuthStates
import kotlinx.coroutines.flow.Flow

interface FirebaseRepo {
    fun requestForLogin(email: String, password: String): Flow<AuthStates>
    fun requestForSignUp(user: User): Flow<AuthStates>
    fun loadAccountInfo(): Flow<AuthStates>
}