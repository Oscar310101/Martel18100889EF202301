package com.example.martel18100889ef202301

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.martel18100889ef202301.Model.MoviesFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var auth = FirebaseAuth.getInstance()

        val txtEmail = findViewById<EditText>(R.id.etEmail)
        val txtPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnIngresar)

        btnLogin.setOnClickListener {
            val correo = txtEmail.text.toString()
            val clave = txtPassword.text.toString()

            auth
                .signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Inicio de sesión exitoso",
                                Snackbar.LENGTH_LONG
                            ).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        //Credenciales inválidas
                        Snackbar
                            .make(
                                findViewById(android.R.id.content),
                                "Credenciales inválidas",
                                Snackbar.LENGTH_LONG
                            ).show()
                    }

                }
        }
    }
    }
