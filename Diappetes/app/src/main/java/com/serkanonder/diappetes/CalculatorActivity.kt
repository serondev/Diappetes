package com.serkanonder.diappetes

import android.R
import android.annotation.SuppressLint
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
import java.time.Year

class CalculatorActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityCalculatorBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawerLayout: DrawerLayout = findViewById(com.serkanonder.diappetes.R.id.drawerLayout_calculator)
        val navView: NavigationView = findViewById(com.serkanonder.diappetes.R.id.nav_view_calculator)
        val headerView = nav_view_calculator.getHeaderView(0)
        var totalCarbs : Int = 0
        val totalBolus : Int = 0
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

        val foods = arrayOf(
            Pair("Lahmacun",50),
            Pair("Baklava",25),
            Pair("K??fte",0),
            Pair("Kebap",45),
            Pair("Kuru Fasulye",80),
            Pair("Mercimek ??orbas??",20),
            Pair("Kuru Baklagil",50),
            Pair("Pizza(Dilim)",25),
            Pair("Peynirli Sandvi??",30),
            Pair("Ekmek(Dilim)",15),
            Pair("Tavuk",0),
            Pair("Et",0),
            Pair("Bal??k",0),
            Pair("Meyve",15),
            Pair("Sebze",0),
            Pair("S??t",5),
            Pair("Yo??urt",5),
            Pair("S??t ??r??nleri",5),
            Pair("Mant??( 1 Porsiyon)",80),
            Pair("Makarna( 5 Ka????k)",32),
            Pair("Pilav( 5 Ka????k)",37),
            Pair("Patates( 1 Adet)",15),
            Pair("Patates K??zartmas??( 1 Adet)",50),
            Pair("Kuru Baklagil( 1 Porsiyon)",50),
            Pair("Tavuklu Patates K??zartmas??( 1 Porsiyon)",63),
            Pair("Tavuklu Makarna( 1 Porsiyon)",40),
            Pair("Zeytin",0),
            Pair("Yulaf Ezmesi (100g)",53),
            Pair("Pancake (1 Adet)",12),
            Pair("Sucuklu Tost (Adet)",20),
            Pair("Ka??arl?? Tost (Adet)",20),
            Pair("Kek (1 Dilim)",15),
            Pair("B??rek (1 Dilim)",25),
            Pair("Patatesli B??rek (1 Adet)",25),
            Pair("Sosis",0),
            Pair("Kahvalt??l??k Meyve (Orta Boy)",10),
            Pair("Kabak ??i??e??i Dolmas?? (Tane)",15),
            Pair("G??zlemes (1 Adet)",30),
            Pair("Peynir",0),
            Pair("Kekik",0),
            Pair("K??rm??z?? Biber",0),
            Pair("Ye??il Biber",0),
            Pair("Domates",0),
            Pair("Patl??can",0),
            Pair("Havu??",0),
            Pair("Kabak",0),
            Pair("Kuru So??an",0),
            Pair("Maydanoz",0),
            Pair("Salatal??k",0),
            Pair("Sar??msak",0),
            Pair("Zeytin Ya????",0),
            Pair("??ncir",10),
            Pair("Kavun",10),
            Pair("Kivi",10),
            Pair("Mandalina",10),
            Pair("Muz",20),
            Pair("Portakal",10),
            Pair("??eftali",15),
            Pair("??z??m",20),
            Pair("Yaban Mersini",10),
            Pair("Kay??s??",4),
            Pair("Karpuz",10),
            Pair("Bal Kaba????",7),
            Pair("Kuru Kay??s??",6),
            Pair("Kuru ??z??m",3),
            Pair("Kuru ??ilek",3),
            Pair("Kuru Kavun",10),
            Pair("Kuru Muz",3),
            Pair("Kuru Portakal",5),
            Pair("Kuru ??eftali",4),
            Pair("Kuru Yaban Mersini",3),
            Pair("F??nd??k (Bir Avu??)",3),
            Pair("F??st??k (Bir Avu??)",4),
            Pair("Badem (Bir Avu??)",3),
            Pair("Kaju (Bir Avu??)",5),
            Pair("Kar??????k Kuruyemi?? (Bir Fincan)",5),
            Pair("Bal (2.5 Tatl?? Ka????????)",20),
            Pair("Cici Bebe Bisk??vi (Tane)",5),
            Pair("??ikolata (3 K??????k Par??a)",30),
            Pair("Pekmez (1 Yemek Ka????????)",20),
            Pair("Petib??r (3 Adet)",18),
            Pair("Marmelat (1 Yemek Ka????????)",20),
            Pair("Tahin Helva)",30),
            Pair("Etli Yaprak Sarma (6 Adet)",22),
            Pair("Etli Kabak Dolmas?? (1 Orta Boy)",20),
            Pair("Etli Lahana Sarma (3 Adet)",22),
            Pair("Zeytinya??l?? Biber Dolma (1 Orta Boy",17),
            Pair("Zeytinya??l?? Lahana Sarma (3 Adet)",40),
            Pair("Zeytinya??l?? Yaprak Sarma (6 Adet)",30),
            Pair("Lahmacun",30),
            Pair("K??ymal?? Pide",60),
            Pair("Patates Salatas?? (3 Yemek Ka????????)",8),
            Pair("Mercimek K??ftesi",7),
            Pair("????li K??fte ",20),
            Pair("K??s??r (3 Yemek Ka????????)",15),
            Pair("M??cver",5),
            Pair("??i?? K??fte",7),
            Pair("Ya?? Pasta (1 Dilim)",45),
            Pair("Dondurma (1 Top)",10),
            Pair("Muhallebi",55),
            Pair("Su B??re??i",20),
            Pair("G??zleme (Peynir/K??yma)",60),
            Pair("Yumurta",0),
            Pair("Ayran",5)


        )
        val foodsAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, foods.map { it.first })
        val mealAdapter : ArrayAdapter<String> = ArrayAdapter<String>(this,
            R.layout.simple_list_item_1)
        binding.foodList.adapter = foodsAdapter;
        binding.mealList.adapter = mealAdapter;
        binding.swFoods.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.swFoods.clearFocus()
                if (query != null) {
                    binding.foodList.smoothScrollToPosition(foodsAdapter.getPosition(query))
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
        binding.buttonCalculate.setOnClickListener {
            tv_bolus.visibility = View.VISIBLE
            totalCarbs = foods.filter { mealAdapter.getPosition(it.first) != -1 }.map { it.second }.sum()
            tv_bolus.text = "Total Carbohydrate : "+ totalCarbs.toString() + "g"
    }
        binding.buttonDelete.setOnClickListener {
            mealAdapter.clear()
            totalCarbs == 0
            tv_bolus.visibility = View.INVISIBLE
        }
}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
