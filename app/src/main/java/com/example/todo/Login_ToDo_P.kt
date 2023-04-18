package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Login_ToDo_P : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_to_do_p)

        val retroceder4 = findViewById<ImageButton>(R.id.retroceder4)
        val send1 = findViewById<Button>(R.id.send1)

        retroceder4.setOnClickListener{
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        send1.setOnClickListener{
            val intent: Intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}