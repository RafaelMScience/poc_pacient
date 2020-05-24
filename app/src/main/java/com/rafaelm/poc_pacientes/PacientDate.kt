package com.rafaelm.poc_pacientes

import androidx.databinding.ObservableBoolean
import java.util.*

data class PacientDate(
    val id: Int,
    val cpf: Int,
    val name: String,
    val dores: String,
    val nivelDor: String,
    val desconforto: String,
    val corpo: String,
    val cirurgia: String,
    val periodoCirurgia: String,
    val tipoCirurgia: String,
    val dorCirurgia: String
){

    val isMark = ObservableBoolean(false)
}