package com.serkanonder.diappetes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serkanonder.diappetes.databinding.ActivityCalculatorBinding
import com.serkanonder.diappetes.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonHome.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
        }
    }
}