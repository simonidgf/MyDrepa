package com.mydrepa.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicamentosInf")
data class MedicamentoEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "nomeMed") val nomeMed: String,
    @ColumnInfo(name = "Dose1") val Dose1: String,
    @ColumnInfo(name = "Dose2") val Dose2: String
)