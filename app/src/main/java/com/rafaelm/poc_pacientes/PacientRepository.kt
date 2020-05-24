package com.rafaelm.poc_pacientes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PacientRepository {
    suspend fun getPacientRepository(): List<PacientDate>{
        return withContext(Dispatchers.Default){
            delay(300)
            listOf(
                PacientDate(1, 12345,"joao","costa","20","sim","costa","sim","4 meses","estetica","nao")
            )
        }
    }
}