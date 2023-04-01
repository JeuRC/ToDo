package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Login_Sign_Facebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sign_facebook)

        val retroceder = findViewById<ImageButton>(R.id.retroceder)
        val continue_facebook = findViewById<Button>(R.id.continue_facebook)

        retroceder.setOnClickListener{
            val intent: Intent = Intent(this, Recover_Login_ToDo::class.java)
            startActivity(intent)
        }

        continue_facebook.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}