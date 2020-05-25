package com.rafaelm.poc_pacientes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PacientViewModel(private val repository: PacientRepository) : ViewModel() {

    val pacientLiveData = MutableLiveData<List<PacientDate>>()

    fun getPacientCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val pacient = withContext(Dispatchers.Default) {
                repository.getPacientRepository()
            }

            pacientLiveData.value = pacient
        }
    }

    class PacientViewModelFactory(private val repository: PacientRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PacientViewModel(repository) as T
        }

    }
}
