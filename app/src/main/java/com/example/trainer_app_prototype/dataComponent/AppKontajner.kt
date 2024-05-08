/*
package com.example.trainer_app_prototype.dataComponent
import android.content.Context


interface AppKontajner {
    val personsRepository: PersonRepository
}

class AppDataKontajner(private val context: Context) : AppKontajner {
    /**
     * Implementation for [ItemsRepository]
     */
    override val personRepository: PersonRepository by lazy {
        OfflinePersonRepository(PersonsDatabase.getDatabase(context).personsDao())
    }
}*/