package com.abosala7.workshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var login: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var newAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login = findViewById(R.id.login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        newAccount = findViewById(R.id.new_account)
        MainActivity.addSpannableString(findViewById(R.id.txt_title), applicationContext)
        newAccount.setOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        login.setOnClickListener {
            if (email.text.isEmpty() || password.text.isEmpty()){
                Toast.makeText(applicationContext, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(applicationContext, WelcomeActivity::class.java))
            }

        }
    }
}