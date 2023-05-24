package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class SignIn : AppCompatActivity() {

    private var username2: EditText?=null
    private var email2: EditText?=null
    private var password_ToDo_2: EditText?=null
    private var repeat_password: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        username2=findViewById(R.id.username2)
        email2=findViewById(R.id.email2)
        password_ToDo_2=findViewById(R.id.password_ToDo_2)
        repeat_password=findViewById(R.id.repeat_password)

        val back = findViewById<ImageButton>(R.id.retroceder)
        val login1 = findViewById<Button>(R.id.login1)
        val username2=findViewById<EditText>(R.id.username2)
        val email2=findViewById<EditText>(R.id.email2)
        val password_ToDo_2=findViewById<EditText>(R.id.password_ToDo_2)
        val repeat_password=findViewById<EditText>(R.id.repeat_password)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        back.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        login_facebook.setOnClickListener{
            val intent = Intent(this, SignInFacebook::class.java)
            startActivity(intent)
        }

        login_google.setOnClickListener{
            val intent = Intent(this, SignInGoogle::class.java)
            startActivity(intent)
        }

        login1.setOnClickListener{
            if (username2.text.toString().isEmpty()) {
                Toast.makeText(this,"Enter a user", Toast.LENGTH_LONG).show()
            }else{
                if (email2.text.toString().isEmpty()) {
                    Toast.makeText(this,"Enter an email", Toast.LENGTH_LONG).show()
                }else{
                    if (password_ToDo_2.text.toString().isEmpty()) {
                    Toast.makeText(this, "Enter a password", Toast.LENGTH_LONG).show()
                    }else{
                        if (repeat_password.text.toString().isEmpty()) {
                        Toast.makeText(this, "Repeat password", Toast.LENGTH_LONG).show()
                        }else{
                            confirmPassword()

                        }
                    }
                }
            }
        }
    }
    private fun save (){
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
            val login=Intent(this,Login::class.java).apply {
                val username = findViewById<EditText>(R.id.username2).text.toString()
                val email = findViewById<EditText>(R.id.email2).text.toString()
                val password = findViewById<EditText>(R.id.password_ToDo_2).text.toString()

                putExtra("username", username)
                putExtra("email", email)
                putExtra("password", password)
            }
            startActivity(login)
            Toast.makeText(this,"You have successfully registered", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"Unregistered user", Toast.LENGTH_LONG).show()
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
            save()
            irLogin()
        }else{
            Toast.makeText(this,"Password does not match", Toast.LENGTH_LONG).show()
        }
    }
}