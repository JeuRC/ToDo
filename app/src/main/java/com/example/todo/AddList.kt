package com.example.todo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class AddList : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_list)

        val etDate = findViewById<EditText>(R.id.etDate)

        etDate.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val datePiker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePiker.show(supportFragmentManager, "datePiker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int){

    }
}