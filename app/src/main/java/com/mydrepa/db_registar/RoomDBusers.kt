package com.mydrepa.db_registar

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class RoomDBUsers: RoomDatabase() {
    @Database(entities = [RegistarEntity::class], version = 1)
    abstract class RoomAppDb_Registo: RoomDatabase(){
        abstract fun registoDao(): RegistoDao?

        companion object{
            private var INSTANCE: RoomAppDb_Registo?=null
            fun getappDatabase(context: Context): RoomAppDb_Registo?{
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder<RoomAppDb_Registo>(context.applicationContext, RoomAppDb_Registo::class.java, "AppDB_users")
                            .allowMainThreadQueries()
                            .build()
                }
                return INSTANCE
            }
        }
    }
}