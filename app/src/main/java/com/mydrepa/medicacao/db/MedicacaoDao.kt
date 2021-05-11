package com.mydrepa.medicacao.db

import androidx.room.*

@Dao
interface MedicacaoDao {
    @Query("SELECT * FROM medicacao ORDER BY id DESC")
    fun getAllMedicamento(): List<MedicacaoEntity>?

    @Insert
    fun insertMedicamento(medicamento: MedicacaoEntity?)

    @Delete
    fun deleteMedicamento(medicamento: MedicacaoEntity?)

    @Update
    fun updateMedicamento(medicamento: MedicacaoEntity?)


}