package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Login_Email_ToDo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_email_to_do)

        val retroceder4 = findViewById<ImageButton>(R.id.retroceder4)
        val continue_username_todo = findViewById<Button>(R.id.continue_username_todo)

        retroceder4.setOnClickListener{
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        continue_username_todo.setOnClickListener{
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}