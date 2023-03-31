package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Recover_Login_ToDo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_login_to_do)

        val retroceder = findViewById<ImageButton>(R.id.retroceder)
        val login1 = findViewById<Button>(R.id.login1)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        retroceder.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        login1.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        login_facebook.setOnClickListener{
            val intent: Intent = Intent(this, Login_Sign_Facebook::class.java)
            startActivity(intent)
        }

        login_google.setOnClickListener{
            val intent: Intent = Intent(this, Login_Sign_Google::class.java)
            startActivity(intent)
        }
    }
}