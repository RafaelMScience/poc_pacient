package com.rafaelm.poc_pacientes

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val user = MutableLiveData<List<PacientDate>>()
    private lateinit var navigator: MainNavigator

    fun setNavigator(navigator: MainNavigator) {
        this.navigator = navigator
    }

    fun getUser(): MutableLiveData<List<PacientDate>> {
        setUser()
        return user
    }

    private fun setUser() {
        val users: MutableList<PacientDate> = ArrayList()
        users.add(
            PacientDate(
                1,
                12345,
                "joao",
                "costa",
                "20",
                "sim",
                "costa",
                "sim",
                "4 meses",
                "estetica",
                "nao"
            )
        )

        this.user.value = users
    }

    fun itemClick(user: PacientDate) {
        navigator.onItemClick(user)
    }
}
