package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Recover_Login_ToDo : AppCompatActivity() {

    var username2: EditText?=null
    var email2: EditText?=null
    var password_ToDo_2: EditText?=null
    var repeat_password: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_login_to_do)

        username2=findViewById(R.id.username2)
        email2=findViewById(R.id.email2)
        password_ToDo_2=findViewById(R.id.password_ToDo_2)
        repeat_password=findViewById(R.id.repeat_password)

        val retroceder = findViewById<ImageButton>(R.id.retroceder)
        val login1 = findViewById<Button>(R.id.login1)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        retroceder.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        login1.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        login_facebook.setOnClickListener{
            val intent: Intent = Intent(this, Login_Sign_Facebook::class.java)
            startActivity(intent)
        }

        login_google.setOnClickListener{
            val intent: Intent = Intent(this, Login_Sign_Google::class.java)
            startActivity(intent)
        }

        login1.setOnClickListener{

            confirmPassword()
        }
    }
    private fun guardar (){
        val prefuser = getSharedPreferences(username2?.text.toString(), Context.MODE_PRIVATE)
        val prefemail = getSharedPreferences(email2?.text.toString(), Context.MODE_PRIVATE)
        val editor1 = prefuser.edit()
        val editor2 = prefemail.edit()
        editor1.putString("Password", password_ToDo_2?.text.toString())
        editor1.apply()
        editor2.putString("Password", password_ToDo_2?.text.toString())
        editor2.apply()
        username2?.setText("")
        email2?.setText("")
        password_ToDo_2?.setText("")
        repeat_password?.setText("")
    }
    private fun irLogin (){
        val prefuser=getSharedPreferences(username2?.text.toString(), Context.MODE_PRIVATE)
        val prefemail=getSharedPreferences(email2?.text.toString(), Context.MODE_PRIVATE)
        val password1=prefuser.getString("Password", "")
        val password2=prefemail.getString("Password", "")
        if(password1==password_ToDo_2?.text.toString() || password2==password_ToDo_2?.text.toString()){
            val login=Intent(this,MainActivity::class.java)
            startActivity(login)
            Toast.makeText(this,"Se ha registrado exitosamente", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"Usuario no registrado", Toast.LENGTH_LONG).show()
        }
        username2?.setText("")
        email2?.setText("")
        password_ToDo_2?.setText("")
        repeat_password?.setText("")
    }
    private fun confirmPassword (){
        val password=getSharedPreferences(password_ToDo_2?.text.toString(), Context.MODE_PRIVATE)
        val repeatPassword=getSharedPreferences(repeat_password?.text.toString(), Context.MODE_PRIVATE)
        if (password==repeatPassword){
            guardar()
            irLogin()
        }else{
            Toast.makeText(this,"La contraseña no coincide", Toast.LENGTH_LONG).show()
        }
    }
}