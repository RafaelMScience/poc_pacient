package com.rafaelm.poc_pacientes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelm.poc_pacientes.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainNavigator {

//    inner class MainHandler{
//        fun btn_add(){
//            val i = Intent(this@MainActivity, PacientActivity::class.java)
//            startActivity(i)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.setNavigator(this)
        viewModel.getUser().observe(this, Observer { user ->
            binding.recyclerView.adapter = ListAdapter(user, viewModel)
        })


//        proxima tela
        btn_add.setOnClickListener {
            val i = Intent(this, PacientActivity::class.java)
            startActivity(i)
        }

    }

    override fun onItemClick(pacientDate: PacientDate) {
        Toast.makeText(this,"id: "+pacientDate.id, Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putInt("id",pacientDate.id)
        val i = Intent(this, InformationsActivity::class.java)
        i.putExtra("id",bundle)
        startActivity(i)
        onStop()
    }
}