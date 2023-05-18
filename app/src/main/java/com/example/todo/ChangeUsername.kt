package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ChangeUsername : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_username)

        val back = findViewById<ImageButton>(R.id.retroceder4)
        val continua = findViewById<Button>(R.id.continue_username_todo)

        back.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        continua.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}