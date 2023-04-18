package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login1 = findViewById<Button>(R.id.login1)
        val signIn = findViewById<TextView>(R.id.singIn)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        login1.setOnClickListener{
            val intent:Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        signIn.setOnClickListener{
            val intent:Intent = Intent(this, Recover_Login_ToDo::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener{
            val intent:Intent = Intent(this, Recover_Password_ToDo::class.java)
            startActivity(intent)
        }

        login_facebook.setOnClickListener{
            val intent:Intent = Intent(this, Login_Facebook_P::class.java)
            startActivity(intent)
        }

        login_google.setOnClickListener{
            val intent:Intent = Intent(this, Login_Google_P::class.java)
            startActivity(intent)
        }
    }
}