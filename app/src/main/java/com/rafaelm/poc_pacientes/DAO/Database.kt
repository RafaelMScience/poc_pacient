package com.rafaelm.poc_pacientes.DAO

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PacientEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract fun pacientDAO(): PacientDAO
}