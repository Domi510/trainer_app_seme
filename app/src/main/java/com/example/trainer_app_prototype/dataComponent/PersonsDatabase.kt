package com.example.trainer_app_prototype.dataComponent
import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.example.trainer_app_prototype.Osoby.Osoba

@Database(entities = [Osoba::class], version = 1, exportSchema = false) // ak zmeníme niečo v tabuľke dáme increase, false - žiadne backup
abstract class PersonsDatabase : RoomDatabase() {

    abstract fun personsDao(): PersonsDao

    companion object {
        @Volatile
        private var Instance: PersonsDatabase? = null

        fun getDatabase(context: Context): PersonsDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PersonsDatabase::class.java, "persons_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}