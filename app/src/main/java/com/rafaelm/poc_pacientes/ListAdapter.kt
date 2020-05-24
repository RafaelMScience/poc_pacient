package com.rafaelm.poc_pacientes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rafaelm.poc_pacientes.databinding.ItemListBinding


class ListAdapter (
    private var users: List<PacientDate>,
    private var viewModel: MainViewModel
): RecyclerView.Adapter<ListAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun setBinding(
            user: PacientDate,
            viewModel: MainViewModel
        ){
            binding.pacient = user
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater  = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemListBinding>(layoutInflater, R.layout.item_list, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.setBinding(user, viewModel)
    }

}