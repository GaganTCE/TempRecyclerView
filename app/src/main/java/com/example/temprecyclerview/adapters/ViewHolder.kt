package com.example.temprecyclerview.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.temprecyclerview.databinding.ListItemBinding
import com.example.temprecyclerview.domains.StudentDomain
import com.example.temprecyclerview.interfaces.InteractionIntr

class ViewHolder (private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(studentObj : StudentDomain, position : Int, interactionIntr: InteractionIntr){
        binding.tvName.text = studentObj.studentName
        binding.tvRollNo.text = studentObj.rollNo

        binding.root.setOnClickListener {
            interactionIntr.showToast(position)
        }

        binding.root.setOnLongClickListener {
            interactionIntr.removeItem(position)
            true
        }
    }
}