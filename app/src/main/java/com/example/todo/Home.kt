package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imgTasks = findViewById<ImageView>(R.id.imgTasks)

        imgTasks.setOnClickListener{
            val intent: Intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
    }
}