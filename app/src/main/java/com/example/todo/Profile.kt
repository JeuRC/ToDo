package com.example.todo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth

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
            val prefs = getSharedPreferences(getString(R.string.title_home), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            LoginManager.getInstance().logOut()

            FirebaseAuth.getInstance().signOut()
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
    }
}