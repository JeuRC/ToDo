package com.example.todo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class Profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val imgBack = findViewById<ImageButton>(R.id.imgBack)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val imgEdit1 = findViewById<ImageButton>(R.id.imgEdit1)
        val imgEdit2 = findViewById<ImageButton>(R.id.imgEdit2)
        val imgEdit3 = findViewById<ImageButton>(R.id.imgEdit3)

        imgBack.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        btnLogout.setOnClickListener{
            val prefs = getSharedPreferences(getString(R.string.enter_username), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        imgEdit1.setOnClickListener{
            val intent = Intent(this, ChangeUsername::class.java)
            startActivity(intent)
        }
        imgEdit2.setOnClickListener{
            val intent = Intent(this, ChangeEmail::class.java)
            startActivity(intent)
        }
        imgEdit3.setOnClickListener{
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }

        profile()
    }

    private fun profile() {
        val prefs = getSharedPreferences(getString(R.string.enter_username), Context.MODE_PRIVATE)
        val username = prefs.getString("username", null)
        val email = prefs.getString("email", null)
        val password = prefs.getString("password", null)

        Toast.makeText(this,username, Toast.LENGTH_LONG).show()

        if (username != null && email != null && password != null){
            val txtName = findViewById<TextView>(R.id.txtName)
            val txtEmail_address = findViewById<TextView>(R.id.txtEmail_address)
            val txtCharacters = findViewById<TextView>(R.id.txtCharacters)

            txtName.text = username
            txtEmail_address.text = email
            txtCharacters.text = password
        }
    }
}