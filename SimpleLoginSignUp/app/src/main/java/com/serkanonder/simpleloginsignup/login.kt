package com.serkanonder.simpleloginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginbutton2 = findViewById<com.google.android.material.button.MaterialButton>(R.id.loginbutton2)
        loginbutton2.setOnClickListener() {
            val intent = android.content.Intent(this, placelist::class.java)
            val username = findViewById<EditText>(R.id.username)
            val password = findViewById<EditText>(R.id.password)
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            if (usernameText == "serkan" && passwordText == "1234") {
                Toast.makeText(this, "Welcome $usernameText", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
            startActivity(intent)
        }

    }
}