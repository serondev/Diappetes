package com.serkanonder.diappetes

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.serkanonder.diappetes.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.*
import kotlinx.android.synthetic.main.nav_header.view.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailId = intent.getStringExtra("email_id")
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView = navView.getHeaderView(0)
        headerView.user_name.text = "Welcome $emailId"
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    val intent = Intent(this@MainActivity, ProfileActivity::class.java)
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
        button_call_doctor.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:05323876864").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }
        button_text_doctor.setOnClickListener {
            val smsIntent: Intent = Uri.parse("smsto:05323876864").let { number ->
                Intent(Intent.ACTION_SENDTO, number)
            }
            startActivity(smsIntent)
        }
        btnPairDevices.setOnClickListener {
            val intent = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
            startActivity(intent)

        }
        button_sugar_level.setOnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.component = ComponentName("com.omfaer.bluetoothcontrol", "com.omfaer.bluetoothcontrol.MainActivity")
            startActivity(intent)



        }





    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
