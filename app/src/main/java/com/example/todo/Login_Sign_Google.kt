package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Login_Sign_Google : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_google)

        val retroceder = findViewById<ImageButton>(R.id.retroceder)
        val continue_google = findViewById<Button>(R.id.continue_google)

        retroceder.setOnClickListener{
            val intent: Intent = Intent(this, Recover_Login_ToDo::class.java)
            startActivity(intent)
        }

        continue_google.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}