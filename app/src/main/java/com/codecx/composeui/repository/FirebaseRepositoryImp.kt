package com.codecx.composeui.repository

import android.content.Context
import com.codecx.composeui.models.User
import com.codecx.composeui.sealclasses.AuthStates
import com.codecx.composeui.utils.UserDataHolder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@ViewModelScoped
class FirebaseRepositoryImp @Inject constructor(
    @ApplicationContext private val context: Context,
    private val auth: FirebaseAuth
) :
    FirebaseRepo {
    private val userRef = FirebaseDatabase.getInstance().getReference("users")
    override fun requestForLogin(email: String, password: String): Flow<AuthStates> =
        flow {
            val authTask = auth.signInWithEmailAndPassword(email, password).await()
            authTask?.user?.let {
                val info = userRef.child(it.uid).get().await()
                UserDataHolder.user = info.getValue(User::class.java)
                emit(AuthStates.Success)
            } ?: emit(AuthStates.Fail("Email alebo heslo sa nezhodujú !"))
        }.flowOn(Dispatchers.IO)

    override fun requestForSignUp(user: User): Flow<AuthStates> = flow {

        val authTask = auth.createUserWithEmailAndPassword(user.email, user.password).await()
        authTask.user?.let {
            userRef.child(it.uid).setValue(user).await()
            UserDataHolder.user = user
            emit(AuthStates.Success)
        } ?: emit(AuthStates.Fail("Prihlásenie zlyhalo"))
    }.flowOn(Dispatchers.IO)

    override fun loadAccountInfo(): Flow<AuthStates> = flow<AuthStates> {
        if (auth.currentUser != null) {
            val info = userRef.child(auth.currentUser?.uid!!).get().await()
            UserDataHolder.user = info.getValue(User::class.java)
        } else {
            UserDataHolder.user = User("Ivan Kácerík - Zilina", "holder@gmail.com", "+1423590807")
        }
        emit(AuthStates.Success)

    }.flowOn(Dispatchers.IO)

}