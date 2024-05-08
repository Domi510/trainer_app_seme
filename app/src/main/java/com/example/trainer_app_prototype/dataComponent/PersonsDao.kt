/*package com.example.trainer_app_prototype.dataComponent
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.trainer_app_prototype.Osoby.Osoba


@Dao
interface PersonsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(osoba: Osoba)

    @Update
    suspend fun update(osoba: Osoba)

    @Delete
    suspend fun delete(osoba: Osoba)

    @Query("SELECT * from users WHERE id = :id")
    fun getPerson(id: Int): Flow<Osoba>

    @Query("SELECT * from users ORDER BY meno ASC")
    fun getAllPersons(): Flow<List<Osoba>>

}*/