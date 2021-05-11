package com.mydrepa.medicacao

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mydrepa.RoomAppDB
import com.mydrepa.medicacao.db.MedicacaoEntity

class MedicacaoActivityViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allMedicamentos : MutableLiveData<List<MedicacaoEntity>>

    init{
        allMedicamentos = MutableLiveData()
        getAllMedicamentos()
    }

    fun getAllMedicamentosObservers(): MutableLiveData<List<MedicacaoEntity>>{
        return allMedicamentos
    }

    fun getAllMedicamentos(){
        val medicacaoDao = RoomAppDB.getAppDatabase((getApplication()))?.medicacaoDao()
        val list = medicacaoDao?.getAllMedicamento()

        allMedicamentos.postValue(list)
    }


    fun insertMedicamentoInfo(entity: MedicacaoEntity){
        val medicacaoDao = RoomAppDB.getAppDatabase((getApplication()))?.medicacaoDao()
        medicacaoDao?.insertMedicamento(entity)
        getAllMedicamentos()
    }

    fun deleteMedicamentoInfo(entity: MedicacaoEntity){
        val medicacaoDao = RoomAppDB.getAppDatabase(getApplication())?.medicacaoDao()
        medicacaoDao?.deleteMedicamento(entity)
        getAllMedicamentos()
    }

    fun updateMedicamentoInfo(entity: MedicacaoEntity){
        val medicacaoDao = RoomAppDB.getAppDatabase(getApplication())?.medicacaoDao()
        medicacaoDao?.updateMedicamento(entity)
        getAllMedicamentos()
    }
}

