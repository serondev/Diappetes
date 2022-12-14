package com.serkanonder.diappetes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.serkanonder.diappetes.databinding.ActivityCalculatorBinding
import com.serkanonder.diappetes.databinding.ActivityProfileBinding
import com.serkanonder.diappetes.login.LoginActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.nav_header.view.*

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view_profile)
        val headerView = navView.getHeaderView(0)
        val bfFactor = binding.tvBfFactor.text.toString()
        val lunchFactor = binding.tvLunchFactor.text.toString()
        val dinnerFactor = binding.tvDinnerFactor.text.toString()
        headerView.user_name.text = "Diappetes Menu"
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_profile.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    val intent = Intent(this@ProfileActivity, ProfileActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_calculate -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_medical -> {
                    val intent = Intent(this, MedicalActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
        binding.buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@ProfileActivity, LoginActivity::class.java))
            finish()
        }

        button_enter.setOnClickListener {
            tv_bf_value.text = bfFactor
            tv_lnch_value.text = lunchFactor
            tv_dinner_value.text = dinnerFactor
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

