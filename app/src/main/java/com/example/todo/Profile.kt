package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imgBack = findViewById<ImageButton>(R.id.imgBack)
        val btnLagout = findViewById<Button>(R.id.btnLagout)
        val imgEdit1 = findViewById<ImageButton>(R.id.imgEdit1)
        val imgEdit2 = findViewById<ImageButton>(R.id.imgEdit2)
        val imgEdit3 = findViewById<ImageButton>(R.id.imgEdit3)

        imgBack.setOnClickListener{
            val intent: Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        btnLagout.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        imgEdit1.setOnClickListener{
            val intent: Intent = Intent(this, Login_Email_ToDo::class.java)
            startActivity(intent)
        }
        imgEdit2.setOnClickListener{
            val intent: Intent = Intent(this, Login_ToDo_P::class.java)
            startActivity(intent)
        }
        imgEdit3.setOnClickListener{
            val intent: Intent = Intent(this, Recover_Password_ToDo::class.java)
            startActivity(intent)
        }
    }
}