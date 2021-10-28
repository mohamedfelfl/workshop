package com.abosala7.workshop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable

import android.text.style.ForegroundColorSpan

import android.text.SpannableString

import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    private lateinit var signUp:Button
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var alreadyText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signUp = findViewById(R.id.signup)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        alreadyText = findViewById(R.id.already_exists)
        addSpannableString(findViewById(R.id.txt_title), applicationContext)
        alreadyText.setOnClickListener{
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
        signUp.setOnClickListener {
            if (name.text.isEmpty() || email.text.isEmpty() || password.text.isEmpty()){
                Toast.makeText(applicationContext, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(applicationContext, WelcomeActivity::class.java))
            }

        }

    }

    companion object {
        fun addSpannableString(textView: TextView, context: Context) {
            val wordToSpan: Spannable = SpannableString("Meal Monkey")
            wordToSpan.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(context, R.color.orange)),
                0,
                4,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            wordToSpan.setSpan(
                ForegroundColorSpan(Color.BLACK),
                5,
                wordToSpan.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            textView.text = wordToSpan
        }
    }
}