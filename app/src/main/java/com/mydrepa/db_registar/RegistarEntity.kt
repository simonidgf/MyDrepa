package com.mydrepa.db_registar

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class RegistarEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "nome") val nome: String = "",
    @ColumnInfo(name = "apelido") val apelido: String = "",
    @ColumnInfo(name = "genero") val genero: String = "",
    @ColumnInfo(name = "email") val email: String = "",
    @ColumnInfo(name = "nacionalidade") val nacionalidade: String = "",
    @ColumnInfo(name = "num_telemovel") val num_telemovel: String = "",
    @ColumnInfo(name = "password") val password: String = ""
)