package com.example.trainer_app_prototype.Osoby
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class Osoba {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
    var vek: Int = 0
    var meno: String = ""
    var priezvisko: String = ""


    fun printInfo() {
        println("Vek osoby je: $vek")

    }
}