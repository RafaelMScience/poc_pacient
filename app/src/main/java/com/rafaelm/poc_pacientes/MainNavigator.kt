package com.rafaelm.poc_pacientes

import android.view.View
import android.widget.Toast

interface MainNavigator {
    fun onItemClick(pacientDate: PacientDate)
}
