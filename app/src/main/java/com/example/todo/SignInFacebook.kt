package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class SignInFacebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_facebook)

        val back = findViewById<ImageButton>(R.id.retroceder)
        val continua = findViewById<Button>(R.id.continue_facebook)

        back.setOnClickListener{
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        continua.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}