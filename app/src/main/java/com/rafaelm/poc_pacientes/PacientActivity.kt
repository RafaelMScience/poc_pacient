package com.rafaelm.poc_pacientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelm.poc_pacientes.databinding.ActivityPacientBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pacient.*

class PacientActivity : AppCompatActivity() {

    private lateinit var pacientViewModel: PacientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacient)

        val binding: ActivityPacientBinding = DataBindingUtil.setContentView(this, R.layout.activity_pacient)

        pacientViewModel = ViewModelProvider(this, PacientViewModel.PacientViewModelFactory(PacientRepository())).get(PacientViewModel::class.java)

        edt_cpf.addTextChangedListener(Mask.mask("###.###.###-##", edt_cpf))

        //para teste do app
        edt_cpf.setOnClickListener {
            if (CPFUtil.myValidateCPF(edt_cpf.text.toString())) {
                edt_name.visibility = View.VISIBLE
                group_dor.visibility = View.VISIBLE

            } else {
                edt_name.visibility = View.GONE
                group_dor.visibility = View.GONE
                edt_intens.visibility = View.GONE
                group_desconforto.visibility = View.GONE
                layout_corpo.visibility = View.GONE
                group_cirurgia.visibility = View.GONE
                group_tempo.visibility = View.GONE
                group_tipo.visibility = View.GONE
                group_fezcirurgia.visibility = View.GONE
                Toast.makeText(this, "Digite um CPF valido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
