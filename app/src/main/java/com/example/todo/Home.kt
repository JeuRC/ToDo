package com.example.todo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val imgTasks = findViewById<ImageView>(R.id.imgTasks)
        val txtTasks = findViewById<TextView>(R.id.txtTasks)
        val imgLists = findViewById<ImageView>(R.id.imgLists)
        val txtLists = findViewById<TextView>(R.id.txtLists)
        val imgCalendar = findViewById<ImageView>(R.id.imgCalendar)
        val txtCalendar = findViewById<TextView>(R.id.txtCalendar)
        val imgTeams = findViewById<ImageView>(R.id.imgTeams)
        val txtTeams = findViewById<TextView>(R.id.txtTeams)

        btnProfile.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        imgTasks.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
        txtTasks.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }
        imgLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        txtLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        imgCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        txtCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        imgTeams.setOnClickListener{
            val intent = Intent(this, Teams::class.java)
            startActivity(intent)
        }
        txtTeams.setOnClickListener{
            val intent = Intent(this, Teams::class.java)
            startActivity(intent)
        }

        saveData()
    }

    private fun saveData() {
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val password = bundle?.getString("password")

        val prefs = getSharedPreferences(getString(R.string.title_home), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("password", password)
        prefs.apply()
    }
}