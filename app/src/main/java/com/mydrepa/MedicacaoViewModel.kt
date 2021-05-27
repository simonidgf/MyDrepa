package com.mydrepa

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mydrepa.db.MedicamentoEntity
import com.mydrepa.db.RoomAppDb

class MedicacaoViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allMedicamentos : MutableLiveData<List<MedicamentoEntity>>

    init{
        allMedicamentos = MutableLiveData()
    }

    fun getAllMedicamentosObservers(): MutableLiveData<List<MedicamentoEntity>>{
        return allMedicamentos
    }

    fun getAllUsers(){
        val medicaDao = RoomAppDb.getAppDatabase((getApplication()))?.medicamentoDao()
        val list = medicaDao?.getAllMedicamentosInfo()

        allMedicamentos.postValue(list)
    }

    fun insertMedicamentoInfo(entity: MedicamentoEntity){
        val medicaDao = RoomAppDb.getAppDatabase(getApplication())?.medicamentoDao()
        medicaDao?.insertMedicamento(entity)
        getAllUsers()
    }

    fun updateMedicamentoInfo(entity: MedicamentoEntity){
        val medicaDao = RoomAppDb.getAppDatabase(getApplication())?.medicamentoDao()
        medicaDao?.updateMedicamento(entity)
        getAllUsers()
    }

    fun deleteMedicamentoInfo(entity: MedicamentoEntity){
        val medicaDao = RoomAppDb.getAppDatabase(getApplication())?.medicamentoDao()
        medicaDao?.deleteMedicamento(entity)
        getAllUsers()
    }


}