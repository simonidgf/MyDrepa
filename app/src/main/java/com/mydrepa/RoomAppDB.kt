package com.mydrepa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mydrepa.medicacao.db.MedicacaoDao
import com.mydrepa.medicacao.db.MedicacaoEntity

@Database(entities = [MedicacaoEntity::class], version = 1)
abstract class RoomAppDB: RoomDatabase() {

    abstract fun medicacaoDao(): MedicacaoDao?

    companion object{
        private var INSTANCE: RoomAppDB?=null

        fun getAppDatabase(context: Context): RoomAppDB?{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<RoomAppDB>(
                    context.applicationContext, RoomAppDB::class.java, "AppDB"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

}