package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class Login : AppCompatActivity() {

    private var username_principal: EditText?=null
    private var contraseña_principal: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        screenSplash.setKeepOnScreenCondition { false }

        username_principal=findViewById(R.id.username_principal)
        contraseña_principal=findViewById(R.id.contraseña_principal)

        val login1 = findViewById<Button>(R.id.login1)
        val username_principal=findViewById<EditText>(R.id.username_principal)
        val contraseña_principal=findViewById<EditText>(R.id.contraseña_principal)
        val signIn = findViewById<TextView>(R.id.singIn)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        login1.setOnClickListener{
            if (username_principal.text.toString().isEmpty()) {
                Toast.makeText(this,"Enter a user", Toast.LENGTH_LONG).show()
            }else{
                if (contraseña_principal.text.toString().isEmpty()) {
                    Toast.makeText(this,"Enter an email address", Toast.LENGTH_LONG).show()
                }else{
                    val prefuser=getSharedPreferences(username_principal?.text.toString(), Context.MODE_PRIVATE)
                    val password=prefuser.getString("Password", "")
                    if(password==contraseña_principal?.text.toString()){
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"You have successfully logged in", Toast.LENGTH_LONG).show()
                        data()
                    } else{
                        Toast.makeText(this,"Unregistered user", Toast.LENGTH_LONG).show()
                    }
                    username_principal?.setText("")
                    contraseña_principal?.setText("")
                }
            }
        }
        signIn.setOnClickListener{
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener{
            val intent = Intent(this, RecoverPassword::class.java)
            startActivity(intent)
        }

        login_facebook.setOnClickListener{
            val intent = Intent(this, LoginFacebook::class.java)
            startActivity(intent)
        }

        login_google.setOnClickListener{
            val intent = Intent(this, LoginGoogle::class.java)
            startActivity(intent)
        }
    }

    private fun data() {
        val bundle = intent.extras
        val username = bundle?.getString("username")
        val email = bundle?.getString("email")
        val password = bundle?.getString("password")

        val prefs = getSharedPreferences(getString(R.string.enter_username), Context.MODE_PRIVATE).edit()
        prefs.putString("username", username)
        prefs.putString("email", email)
        prefs.putString("password", password)
        prefs.apply()
    }
}