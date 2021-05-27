package com.mydrepa.db

import androidx.room.*

@Dao
interface MedicamentoDao {
    @Query("SELECT * From medicamentosInf ORDER BY id DESC")
    fun getAllMedicamentosInfo(): List<MedicamentoEntity>?

    @Insert
    fun insertMedicamento(medicamento: MedicamentoEntity?)

    @Delete
    fun deleteMedicamento(medicamento: MedicamentoEntity?)

    @Update
    fun updateMedicamento(medicamento: MedicamentoEntity?)

}