package com.example.temprecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.temprecyclerview.databinding.ListItemBinding
import com.example.temprecyclerview.domains.StudentDomain
import com.example.temprecyclerview.interfaces.InteractionIntr
//
//class StudentAdapter(private val list : ArrayList<StudentDomain>,private val interactionIntr: InteractionIntr) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(){
//    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(studentObj : StudentDomain, interactionIntr: InteractionIntr, position: Int){
//            binding.tvName.text = studentObj.studentName
//            binding.tvRollNo.text = studentObj.rollNo
//
//            binding.root.setOnClickListener {
//                interactionIntr.showToast(position)
//            }
//
//            binding.root.setOnLongClickListener {
//                interactionIntr.removeItem(position)
//                true
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ViewHolder(itemBinding)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(list[position],interactionIntr,position)
////        holder.binding.tvName.text = list[position].studentName
////        holder.binding.tvRollNo.text = list[position].rollNo
////        holder.itemView.setOnClickListener {
////            interactionIntr.showToast(position)
////        }
////
////        holder.itemView.setOnLongClickListener {
////            interactionIntr.removeItem(position)
////            true
////        }
//    }
//
//}

class StudentAdapter(private val list : ArrayList<StudentDomain>, private val interactionIntr: InteractionIntr) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position],position,interactionIntr)
    }

}
