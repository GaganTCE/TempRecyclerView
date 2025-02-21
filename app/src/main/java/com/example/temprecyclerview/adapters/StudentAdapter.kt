package com.example.temprecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.temprecyclerview.databinding.ListItemBinding
import com.example.temprecyclerview.domains.StudentDomain
import com.example.temprecyclerview.interfaces.InteractionIntr

class StudentAdapter(private val list : ArrayList<StudentDomain>, private val interactionIntr: InteractionIntr) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemListBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemListBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = list[position].studentName
        holder.binding.tvRollNo.text = list[position].rollNo

        holder.itemView.setOnClickListener {
            interactionIntr.showToast(position)
        }

        holder.itemView.setOnLongClickListener {
            interactionIntr.removeItem(position)
            true
        }
    }

}