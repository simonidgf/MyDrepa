package com.mydrepa.db_registar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mydrepa.db.MedicamentoEntity
import com.mydrepa.db.RoomAppDb
import com.mydrepa.db_registar.RoomDBUsers.RoomAppDb_Registo
import com.mydrepa.db_registar.RoomDBUsers.RoomAppDb_Registo.Companion.getappDatabase

class RegistoViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allUsers : MutableLiveData<List<RegistarEntity>>

    init{
        allUsers = MutableLiveData()
    }

    fun getAllMedicamentosObservers(): MutableLiveData<List<RegistarEntity>> {
        return allUsers
    }

    fun getAllUsers(){
        val regiDao = RoomAppDb_Registo.getappDatabase((getApplication()))?.registoDao()
        val list = regiDao?.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: RegistarEntity){
        val medicaDao = RoomAppDb_Registo.getappDatabase(getApplication())?.registoDao()
        medicaDao?.insertUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: RegistarEntity){
        val medicaDao = RoomAppDb_Registo.getappDatabase(getApplication())?.registoDao()
        medicaDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: RegistarEntity){
        val medicaDao = RoomAppDb_Registo.getappDatabase(getApplication())?.registoDao()
        medicaDao?.deleteUser(entity)
        getAllUsers()
    }


}