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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicalBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    }
}
