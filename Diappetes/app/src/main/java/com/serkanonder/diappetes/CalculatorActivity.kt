package com.serkanonder.diappetes

import android.R
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import com.serkanonder.diappetes.databinding.ActivityCalculatorBinding
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.nav_header.view.*

class CalculatorActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawerLayout: DrawerLayout = findViewById(com.serkanonder.diappetes.R.id.drawerLayout_calculator)
        val navView: NavigationView = findViewById(com.serkanonder.diappetes.R.id.nav_view_calculator)
        val headerView = nav_view_calculator.getHeaderView(0)
        headerView.user_name.text = "Diappetes Menu"
        toggle = ActionBarDrawerToggle(this, drawerLayout, com.serkanonder.diappetes.R.string.open, com.serkanonder.diappetes.R.string.close)
        drawerLayout_calculator.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                com.serkanonder.diappetes.R.id.nav_profile -> {
                    val intent = Intent(this@CalculatorActivity, ProfileActivity::class.java)
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
        val foods = arrayOf("Mercimek Çorbası","Ezogelin Çorbası","Tarhana Çorbası","Şakşuka","Kısır","Lahmacun","Mercimek Köfte","Yaprak Dolma","Inegöl Köfte",
        "İskender","Cağ Kebap","Beyti","Hamsili Pilav","Perde Pilavı","Testi Kebap","Su Böreği","Tepsi Böreği","Menemen","Biber Dolması",
        "Barbunya","Imam Bayıldı","Mücver","Türlü","Karnıyarık","Musakka","Ali Nazik","Kıymalı Pide","Kuzu Tandır","Kuzu Şiş","Kuzu Pirzola","Sucuklu Yumurta","Ezme",
        "Beyaz Ekmek","Kepekli Ekmek","Tam Buğday Ekmeği","Yumurta","Poğaça(Pastane)","Kaymak","Katmer","Künefe","Gözleme","Bazlama","Simit","Açma",
        "Aşure","Çilbir","Nevzine","Karışık Tost","Kaşarlı Tost","Kavurmalı Tost")
        val foodsAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.simple_list_item_1,foods)
        val mealAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.simple_list_item_1)
        binding.foodList.adapter = foodsAdapter;
        binding.mealList.adapter = mealAdapter;
        binding.swFoods.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.swFoods.clearFocus()
                if(foods.contains(query)){
                    foodsAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                foodsAdapter.filter.filter(newText)
                return false
            }


        })
        checkBox_breakfast.setOnClickListener {
            if(checkBox_breakfast.isChecked){
                checkBox_lunch.isChecked = false
                checkBox_dinner.isChecked = false
            }
        }
        checkBox_lunch.setOnClickListener {
            if(checkBox_lunch.isChecked){
                checkBox_breakfast.isChecked = false
                checkBox_dinner.isChecked = false
            }
        }
        checkBox_dinner.setOnClickListener {
            if(checkBox_dinner.isChecked){
                checkBox_lunch.isChecked = false
                checkBox_breakfast.isChecked = false
            }
        }
        binding.foodList.setOnItemClickListener { parent, view, position, id ->
            val selectedFood = parent.getItemAtPosition(position).toString()
            if(checkBox_breakfast.isChecked){
                mealAdapter.add(selectedFood)
            }
            if(checkBox_lunch.isChecked){
                mealAdapter.add(selectedFood)
            }
            if(checkBox_dinner.isChecked){
                mealAdapter.add(selectedFood)
            }
        }
        binding.buttonDelete.setOnClickListener {
            mealAdapter.clear()
        }
        binding.buttonCalculate.setOnClickListener {
            tv_bolus.visibility = View.VISIBLE
            tv_bolus.text = "Cannot calculate yet."
    }
}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
