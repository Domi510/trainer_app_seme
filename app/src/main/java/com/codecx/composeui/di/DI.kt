package com.codecx.composeui.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/**
 * S použitím firebase - nevyhnutné
 * SingletonComponent - kontajner pre závislosti,
 * ktoré prežívajú po celú dobu životnosti aplikácie
 * Singleton - FirebaseAuth - jediná inštancia počas celej doby aplikácie
 * Provides v súvisloti Module
 * */
@Module
@InstallIn(SingletonComponent::class)
object Singles {
    @Provides
    @Singleton
    fun auth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}