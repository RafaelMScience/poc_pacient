package com.rafaelm.poc_pacientes.DAO

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PacientEntity(
    @PrimaryKey(autoGenerate = false) val idPacient: Int? = 0,
    @ColumnInfo(name = "name") val namePacient: String?,
    @ColumnInfo(name="cpf") val cpfPacient: Int?,
    @ColumnInfo(name="dores") val doresPacient: String?,
    @ColumnInfo(name="nivelDor") val nivelDor: String?,
    @ColumnInfo(name="descon") val desconforto: String?,
    @ColumnInfo(name="corpo") val corpo: String?,
    @ColumnInfo(name="cirurgia") val cirurgia: String?,
    @ColumnInfo(name="periodoCirurgia") val periodoCirurgia: String?,
    @ColumnInfo(name="tipoCirurgia") val tipoCirurgia: String?,
    @ColumnInfo(name="dorCirurgia") val dorCirurgia: String?
)