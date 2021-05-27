package com.mydrepa.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mydrepa.db_registar.RegistarEntity
import com.mydrepa.db_registar.RegistoDao


@Database(entities = [MedicamentoEntity::class], version = 1)
abstract class RoomAppDb: RoomDatabase() {
    abstract fun medicamentoDao(): MedicamentoDao?

    companion object{
        private var INSTANCE: RoomAppDb?=null
        fun getAppDatabase(context: Context): RoomAppDb?{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<RoomAppDb>(context.applicationContext, RoomAppDb::class.java,"AppDB")
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE
        }
    }
}

@Database(entities = [RegistarEntity::class], version = 1)
abstract class RoomAppDb_Registo: RoomDatabase(){
    abstract fun registoDao(): RegistoDao?

    companion object{
        private var INSTANCE: RoomAppDb_Registo?=null
        fun getAppDatabase(context: Context): RoomAppDb_Registo?{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<RoomAppDb_Registo>(context.applicationContext, RoomAppDb_Registo::class.java, "AppDB_users")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
}