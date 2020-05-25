package com.rafaelm.poc_pacientes.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PacientDAO{
    @Query("SELECT * FROM PacientEntity ORDER BY idPacient DESC")
    fun getAll(): List<PacientEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pacientEntity: PacientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pacientEntity: PacientEntity)
}