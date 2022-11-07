package com.serkanonder.simpleloginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginbutton = findViewById<com.google.android.material.button.MaterialButton>(R.id.loginbutton)
        loginbutton.setOnClickListener() {
            val intent = android.content.Intent(this, login::class.java)
            startActivity(intent)
        }
        val registerbutton =  findViewById<com.google.android.material.button.MaterialButton>(R.id.registerbutton)
        registerbutton.setOnClickListener() {
            val intent = android.content.Intent(this, register::class.java)
            startActivity(intent)
        }
    }
}