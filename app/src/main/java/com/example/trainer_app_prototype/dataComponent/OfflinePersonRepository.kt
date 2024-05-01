package com.example.trainer_app_prototype.dataComponent
import com.example.trainer_app_prototype.Osoby.Osoba
import kotlinx.coroutines.flow.Flow

class OfflinePersonRepository(private val personsDao: PersonsDao) : PersonRepository{
    override fun getAllPersonsStream(): Flow<List<Osoba>> = personsDao.getAllPersons()

    override fun getPersonStream(id: Int): Flow<Osoba?> = personsDao.getPerson(id)

    override suspend fun insertPerson(osoba: Osoba) = personsDao.insert(osoba)

    override suspend fun deletePerson(osoba: Osoba) = personsDao.delete(osoba)

    override suspend fun updatePerson(osoba: Osoba) = personsDao.update(osoba)
}