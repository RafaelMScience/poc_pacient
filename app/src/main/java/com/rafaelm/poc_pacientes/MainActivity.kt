package com.rafaelm.poc_pacientes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: MainActivity = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.setNavigator(this)
        viewModel.getUser().observe(this, Observer { user ->
            binding.recyclerView.adapter = ListAdapter(user, viewModel)
        })

        //proxima tela
        btn_add.setOnClickListener {
            val i = Intent(this, PacientActivity::class.java)
            startActivity(i)
        }

    }

    override fun onItemClick(pacientDate: PacientDate) {
        Toast.makeText(this,"funcoina", Toast.LENGTH_SHORT).show()
    }
}