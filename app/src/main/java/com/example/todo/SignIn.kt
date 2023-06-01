package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignIn : AppCompatActivity() {

    private val GOOGLE_SIGN_IN = 100
    private var username2: EditText?=null
    private var email2: EditText?=null
    private var password_ToDo_2: EditText?=null
    private var repeat_password: EditText?=null
    private val callbackManager = CallbackManager.Factory.create()
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
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult) {
                        result?.let {
                            val token = it.accessToken
                            val email = findViewById<EditText>(R.id.username_principal)
                            val password = findViewById<EditText>(R.id.contraseña_principal)
                            val credential = FacebookAuthProvider.getCredential(token.token)
                            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                                if (it.isSuccessful){
                                    showLogin(email.text.toString(), password.text.toString())
                                }   else {
                                    showAlert() }
                            }

                        }
                    }
                    override fun onCancel() {
                    }
                    override fun onError(error: FacebookException) {
                        showAlert()
                    }

                })
        }

        login_google.setOnClickListener{
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
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

  private fun confirmPassword (){
        val password=getSharedPreferences(password_ToDo_2?.text.toString(), Context.MODE_PRIVATE)
        val repeatPassword=getSharedPreferences(repeat_password?.text.toString(), Context.MODE_PRIVATE)
        if (password==repeatPassword){
            signIn()
        }else{
            Toast.makeText(this,"Password does not match", Toast.LENGTH_LONG).show()
        }
    }

    private fun signIn() {
        val login = findViewById<Button>(R.id.login1)

        val email = findViewById<EditText>(R.id.email2)
        val password = findViewById<EditText>(R.id.password_ToDo_2)

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener {
            if (it.isSuccessful){
                showLogin(email.text.toString(), password.text.toString())
            }else {
                showAlert()
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLogin(email: String, password: String) {
        val intent = Intent(this, Login::class.java).apply {
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)

                if(account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    val email = findViewById<EditText>(R.id.username_principal)
                    val password = findViewById<EditText>(R.id.contraseña_principal)

                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful){
                            showLogin(email.text.toString(), password.text.toString())
                        }else {
                            showAlert()
                        }
                    }
                }
            }catch (e: ApiException) {
                showAlert()
            }
        }
    }
}