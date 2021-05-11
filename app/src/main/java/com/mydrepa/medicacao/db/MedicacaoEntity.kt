package com.mydrepa.medicacao.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicacao")
data class MedicacaoEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "nome_medicamento") val nome_medicamento: String,
    @ColumnInfo(name = "data1") val data1: String,
    @ColumnInfo(name = "data2") val data2: String
)