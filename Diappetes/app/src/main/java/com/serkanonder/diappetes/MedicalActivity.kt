package com.serkanonder.diappetes

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.serkanonder.diappetes.databinding.ActivityCalculatorBinding
import com.serkanonder.diappetes.databinding.ActivityMedicalBinding
import kotlinx.android.synthetic.main.activity_medical.*
import kotlinx.android.synthetic.main.nav_header.view.*

class MedicalActivity : AppCompatActivity() {


    lateinit var binding: ActivityMedicalBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = "https://enabiz.gov.tr/Randevular/Index?RandevuAl=true"
        val url_2 = "https://enabiz.gov.tr/Randevular/Index"
        val drawerLayout: DrawerLayout = findViewById(com.serkanonder.diappetes.R.id.drawerLayout)
        val navView: NavigationView = findViewById(com.serkanonder.diappetes.R.id.nav_view_medical)
        val headerView = nav_view_medical.getHeaderView(0)
        headerView.user_name.text = "Diappetes Menu"
        toggle = ActionBarDrawerToggle(this, drawerLayout, com.serkanonder.diappetes.R.string.open, com.serkanonder.diappetes.R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_medical.setNavigationItemSelectedListener {
            when (it.itemId) {
                com.serkanonder.diappetes.R.id.nav_profile -> {
                    val intent = Intent(this@MedicalActivity, ProfileActivity::class.java)
                    startActivity(intent)
                }
                com.serkanonder.diappetes.R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                com.serkanonder.diappetes.R.id.nav_calculate -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    startActivity(intent)
                }
                com.serkanonder.diappetes.R.id.nav_medical -> {
                    val intent = Intent(this, MedicalActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }

        val hospital = arrayOf("Yenimahalle Devlet Hastanesi","Ankara Şehir Hastanesi","MedicalPark Ankara Hastanesi","Güven Hastanesi",
        "Medicana Sincan Hastanesi","Medicana Ankara Hastanesi","Ankara Numune Hastanesi","Ankara Eğitim ve Araştırma Hastanesi")
        val department = arrayOf("Kardiyoloji","Göz Hastalıkları","Dahiliye","Nöroloji","KBB","Göğüs Hastalıkları","Kadın Hastalıkları ve Doğum","Çocuk Sağlığı ve Hastalıkları")
        val hospitalAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.simple_list_item_1,hospital)
        val departmentAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.simple_list_item_1,department)

        binding.hospitalList.adapter = hospitalAdapter;
        binding.departmentList.adapter = departmentAdapter;
        binding.swAppointment.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.swAppointment.clearFocus()
                if(hospital.contains(query)){
                    hospitalAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                hospitalAdapter.filter.filter(newText)
                return false
            }


        })
        binding.swDepartment.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.swDepartment.clearFocus()
                if(department.contains(query)){
                    departmentAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                departmentAdapter.filter.filter(newText)
                return false
            }


        })

        button_get_appointment.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW)
            i.data = android.net.Uri.parse(url)
            startActivity(i)
        }
        button_history.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW)
            i.data = android.net.Uri.parse(url_2)
            startActivity(i)

        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
