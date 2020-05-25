package com.rafaelm.poc_pacientes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.rafaelm.poc_pacientes.DAO.Database
import com.rafaelm.poc_pacientes.DAO.PacientEntity
import com.rafaelm.poc_pacientes.databinding.ActivityPacientBinding
import kotlinx.android.synthetic.main.activity_pacient.*

class PacientActivity : AppCompatActivity() {

    private lateinit var pacientViewModel: PacientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacient)

        val binding: ActivityPacientBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_pacient)

        pacientViewModel = ViewModelProvider(
            this,
            PacientViewModel.PacientViewModelFactory(PacientRepository())
        ).get(PacientViewModel::class.java)

        edt_cpf.addTextChangedListener(Mask.mask("###.###.###-##", edt_cpf))

        val room =
            Room.databaseBuilder(this, Database::class.java, "meu banco").allowMainThreadQueries()
                .build()

        Thread(Runnable {
            val pacient = PacientEntity(
                idPacient = 0,
                cpfPacient = edt_cpf.text.toString(),
                namePacient = edt_name.text.toString(),
                nivelDor = edt_intens.text.toString(),
                cirurgia = "",
                corpo = "",
                desconforto = "",
                dorCirurgia = "",
                doresPacient = "",
                periodoCirurgia = "",
                tipoCirurgia = ""
            )
            room.pacientDAO().insertAll(pacient)
        }).start()

//        val radio_dor: Int = group_dor!!.checkedRadioButtonId
//        Toast.makeText(baseContext, ""+radio_dor, Toast.LENGTH_SHORT).show()

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
