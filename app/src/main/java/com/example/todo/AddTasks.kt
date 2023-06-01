package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tasks)

        val btnAddTasks = findViewById<Button>(R.id.btnAddTasks)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val etDate = findViewById<EditText>(R.id.etDate)

        btnAddTasks.setOnClickListener {
            val txtTitle = findViewById<EditText>(R.id.txtTitle)
            val intent = Intent(this, Tasks::class.java)
            intent.putExtra("task", txtTitle.text.toString())
            startActivity(intent)
        }

        etDate.setOnClickListener{
            showDatePickerDialog()
        }

        btnCancel.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
    }
    private fun showDatePickerDialog() {
        val datePiker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePiker.show(supportFragmentManager, "datePiker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int){
        val etDate = findViewById<EditText>(R.id.etDate)
        etDate.setText("$day/$month/$year")
    }
}