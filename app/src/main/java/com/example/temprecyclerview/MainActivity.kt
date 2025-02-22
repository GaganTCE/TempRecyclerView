package com.example.temprecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.temprecyclerview.adapters.StudentAdapter
import com.example.temprecyclerview.databinding.ActivityMainBinding
import com.example.temprecyclerview.domains.StudentDomain
import com.example.temprecyclerview.interfaces.InteractionIntr

class MainActivity : AppCompatActivity() , InteractionIntr{
    private lateinit var binding: ActivityMainBinding
    private var studentList: ArrayList<StudentDomain> = arrayListOf()
    private lateinit var adapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        studentList.add(StudentDomain("First", "1"))
        studentList.add(StudentDomain("Second", "2"))
        studentList.add(StudentDomain("Third", "3"))
        studentList.add(StudentDomain("Fourth", "4"))
        studentList.add(StudentDomain("Fifth", "5"))

        adapter = StudentAdapter(studentList,this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun showToast(position: Int) {
        Toast.makeText(this,"You selected : ${studentList[position].studentName}",Toast.LENGTH_SHORT).show()
    }

    override fun removeItem(position: Int) {
        studentList.removeAt(position)
        adapter.notifyDataSetChanged()
    }

}

