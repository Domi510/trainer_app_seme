package com.codecx.composeui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecx.composeui.models.User
import com.codecx.composeui.repository.FirebaseRepositoryImp
import com.codecx.composeui.sealclasses.AuthStates
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    firebaseRepositoryImp: FirebaseRepositoryImp,
    val auth: FirebaseAuth
) :
    ViewModel() {
    private val repo = firebaseRepositoryImp
    private val _authState = MutableStateFlow<AuthStates>(AuthStates.Init)
    val authState = _authState.asStateFlow()
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")

    val email = _email.asStateFlow()
    val password = _password.asStateFlow()

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }
    fun requestForLogin(email: String, password: String) = viewModelScope.launch {
        repo.requestForLogin(email, password).onStart {
            _authState.value = AuthStates.Loading("Prihlasovanie...")
        }.catch {

            _authState.value = AuthStates.Fail("Email alebo heslo je nesprávne")
        }.collectLatest {
            _authState.value = it
        }
    }

    fun loadAccountInfo() = viewModelScope.launch {
        repo.loadAccountInfo().onStart {
            _authState.value = AuthStates.Loading("Hľadám info o účte...")
        }.catch {
            _authState.value = AuthStates.Fail("")
        }.collectLatest {
            _authState.value = it
        }
    }
/**
 * Funkcia, ktorá rieši registráciu priamo pre používateľa
 * kontroluje stav auth_state - odchytáva výnimku, v prípade, že registrácia
 * nie je úspešná
 * */
    fun requestForSignUp(user: User) = viewModelScope.launch {
        repo.requestForSignUp(user).onStart {
            _authState.value = AuthStates.Loading("Prihlasovanie...")
        }.catch {
            _authState.value = AuthStates.Fail("Problém pri registrácii")
        }.collectLatest {
            _authState.value = it
        }
    }

    fun logoutUser() = viewModelScope.launch {
        auth.signOut()
        _authState.value = AuthStates.Fail("Odhlasovanie")
    }
}