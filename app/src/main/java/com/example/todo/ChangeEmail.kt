package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ChangeEmail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)

        val back = findViewById<ImageButton>(R.id.retroceder4)
        val send1 = findViewById<Button>(R.id.send1)

        back.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        send1.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}