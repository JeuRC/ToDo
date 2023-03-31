package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Login_Facebook_P : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_facebook_p)

        val retroceder = findViewById<ImageButton>(R.id.retroceder)

        retroceder.setOnClickListener{
            val intent:Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}