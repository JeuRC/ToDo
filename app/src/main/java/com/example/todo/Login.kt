package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider

class Login : AppCompatActivity() {

    private val GOOGLE_SIGN_IN = 100
    private val callbackManager = CallbackManager.Factory.create()
    override fun onCreate(savedInstanceState: Bundle?) {

        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        screenSplash.setKeepOnScreenCondition { false }

        val login1 = findViewById<Button>(R.id.login1)
        val username_principal = findViewById<EditText>(R.id.username_principal)
        val contraseña_principal = findViewById<EditText>(R.id.contraseña_principal)
        val signIn = findViewById<TextView>(R.id.singIn)
        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        val login_facebook = findViewById<Button>(R.id.login_facebook)
        val login_google = findViewById<Button>(R.id.login_google)

        login1.setOnClickListener {
            if (username_principal.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter a user", Toast.LENGTH_LONG).show()
            } else {
                if (contraseña_principal.text.toString().isEmpty()) {
                    Toast.makeText(this, "Enter an email address", Toast.LENGTH_LONG).show()
                } else {
                    login()
                    session()
                    Toast.makeText(this, "You have successfully logged in", Toast.LENGTH_LONG).show()
                }
            }
        }

        signIn.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener {
            val intent = Intent(this, RecoverPassword::class.java)
            startActivity(intent)
        }


        login_facebook.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult>{
                    override fun onSuccess(result: LoginResult) {
                        result?.let {
                            val token = it.accessToken
                            val email = findViewById<EditText>(R.id.username_principal)
                            val password = findViewById<EditText>(R.id.contraseña_principal)
                            val credential = FacebookAuthProvider.getCredential(token.token)
                            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                                    if (it.isSuccessful){
                                        showHome(email.text.toString(), password.text.toString())
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

        login_google.setOnClickListener {
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build()
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
        }
    }

    override fun onStart() {
        super.onStart()

        val loginLayout = findViewById<ConstraintLayout>(R.id.loginLayout)
        loginLayout.visibility = View.VISIBLE
    }

    private fun session() {
        val prefs = getSharedPreferences(getString(R.string.title_home), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val password = prefs.getString("password", null)

        if(email != null && password != null) {
            val loginLayout = findViewById<ConstraintLayout>(R.id.loginLayout)
            loginLayout.visibility = View.INVISIBLE
            showHome(email, password)
        }
    }

    private fun login() {
        val email = findViewById<EditText>(R.id.username_principal)
        val password = findViewById<EditText>(R.id.contraseña_principal)

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener {
            if (it.isSuccessful){
                showHome(email.text.toString(), password.text.toString())
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

    private fun showHome(email: String, password: String) {
        val intent = Intent(this, Home::class.java).apply {
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        callbackManager.onActivityResult(requestCode, resultCode, data)

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
                            showHome(email.text.toString(), password.text.toString())
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