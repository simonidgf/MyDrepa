package com.mydrepa.db_registar

import androidx.room.*
import com.mydrepa.db.MedicamentoEntity

@Dao
interface RegistoDao {
    @Query("SELECT * From users ORDER BY id DESC")
    fun getAllUserInfo(): List<RegistarEntity>?

    @Insert
    fun insertUser(medicamento: RegistarEntity?)

    @Delete
    fun deleteUser(medicamento: RegistarEntity?)

    @Update
    fun updateUser(medicamento: RegistarEntity?)
}