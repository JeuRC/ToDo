package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Teams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        val imgIcon = findViewById<ImageView>(R.id.imgIcon)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val imgTasks = findViewById<ImageView>(R.id.imgTasks)
        val txtTasks = findViewById<TextView>(R.id.txtTasks)
        val imgLists = findViewById<ImageView>(R.id.imgLists)
        val txtLists = findViewById<TextView>(R.id.txtLists)

        imgIcon.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        btnProfile.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        imgTasks.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
        txtTasks.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
        imgLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        txtLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
    }
}