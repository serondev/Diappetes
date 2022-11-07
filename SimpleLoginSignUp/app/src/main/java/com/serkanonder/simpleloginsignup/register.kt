package com.serkanonder.simpleloginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val signup_button = findViewById<MaterialButton>(R.id.sigupbutton)
        signup_button.setOnClickListener() {
            val username = findViewById<EditText>(R.id.username)
            val password = findViewById<EditText>(R.id.password)
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            if (usernameText == "serkan" && passwordText == "1234") {
                Toast.makeText(this, "Welcome $usernameText", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}