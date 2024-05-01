package com.example.trainer_app_prototype.dataComponent
import com.example.trainer_app_prototype.Osoby.Osoba
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllPersonsStream(): Flow<List<Osoba>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getPersonStream(id: Int): Flow<Osoba?>

    /**
     * Insert item in the data source
     */
    suspend fun insertPerson(osoba: Osoba)

    /**
     * Delete item from the data source
     */
    suspend fun deletePerson(osoba: Osoba)

    /**
     * Update item in the data source
     */
    suspend fun updatePerson(osoba: Osoba)
}