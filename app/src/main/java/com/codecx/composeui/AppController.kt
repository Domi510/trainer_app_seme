package com.codecx.composeui

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
/**
 * trieda Aplikačný kontrolér
 * metóda onCreate je metóda životného cyklu triedy Application,
 * ktorá sa spúšťa pri prvotnom vytvorení inštancie aplikácie
 * Firebase sa tu inicializuje, hlavne z dôvodu, že má byť prítomný
 * pre aktuálnu inštanciu aplikácie
 * */
@HiltAndroidApp
class AppController : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}