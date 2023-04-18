package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Tasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val imgIcon = findViewById<ImageView>(R.id.imgIcon)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val imgLists = findViewById<ImageView>(R.id.imgLists)
        val txtLists = findViewById<TextView>(R.id.txtLists)
        val imgCalendar = findViewById<ImageView>(R.id.imgCalendar)
        val txtCalendar = findViewById<TextView>(R.id.txtCalendar)

        imgIcon.setOnClickListener{
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        btnProfile.setOnClickListener{
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        imgLists.setOnClickListener{
            val intent: Intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        txtLists.setOnClickListener{
            val intent: Intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        imgCalendar.setOnClickListener{
            val intent: Intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        txtCalendar.setOnClickListener{
            val intent: Intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
    }
}