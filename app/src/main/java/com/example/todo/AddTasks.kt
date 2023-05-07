package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddTasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tasks)

        val btnAddTasks = findViewById<Button>(R.id.btnAddTasks)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnAddTasks.setOnClickListener {
            val txtTitle = findViewById<EditText>(R.id.txtTitle)
            val intent = Intent(this, Tasks::class.java)
            intent.putExtra("task", txtTitle.text.toString())
            startActivity(intent)
        }
        btnCancel.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
    }
}