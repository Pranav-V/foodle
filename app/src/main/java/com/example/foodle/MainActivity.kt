package com.example.foodle

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import com.example.foodle.model.FoodData
import com.example.foodle.overview.OverviewViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonNull.serializer


class MainActivity : AppCompatActivity() {
    private val viewModel: OverviewViewModel by viewModels()

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getData()

        // Ref: https://www.youtube.com/watch?v=do4vb0MdLFY
        val drawerLayout = findViewById<DrawerLayout>(R.id.mainContainer)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.app_bar_switch -> {
                    Toast.makeText(applicationContext, "Dark Mode Toggled", Toast.LENGTH_SHORT)
                        .show()
                    toggleDarkMode()
                }
                else -> Toast.makeText(applicationContext, "Error in NavDrawer", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val jclButton = findViewById<Button>(R.id.jclbutton)
        jclButton.setOnClickListener {
            var intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.jclBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.jclLunch.value!!, "lunch")
            val dinner = getJson(viewModel.jclDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Jester City Limits")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }

        val j2Button = findViewById<Button>(R.id.j2button)
        j2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            intent.putExtra("diningHallName", "J2")
            val breakfast = getJson(viewModel.j2Breakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.j2Lunch.value!!, "lunch")
            val dinner = getJson(viewModel.j2Dinner.value!!, "dinner")
            intent.putExtra("diningHallName", "J2")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }

        val fastJ2Button = findViewById<Button>(R.id.fastj2button)
        fastJ2Button.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.fastBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.fastLunch.value!!, "lunch")
            val dinner = getJson(viewModel.fastDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Fast @ J2")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
//            Log.d("dataList", jsonList)
            startActivity(intent)
        }

        val kinsButton = findViewById<Button>(R.id.kinsbutton)
        kinsButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.kinsBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.kinsLunch.value!!, "lunch")
            val dinner = getJson(viewModel.kinsDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Kins")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            Log.d("dataList", breakfast)
            startActivity(intent)
        }

        val jestaPizzaButton = findViewById<Button>(R.id.jestapizzabutton)
        jestaPizzaButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.jestaBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.jestaLunch.value!!, "lunch")
            val dinner = getJson(viewModel.jestaDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Jesta' Pizza")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }

        val littlefieldButton = findViewById<Button>(R.id.littlefieldbutton)
        littlefieldButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.littlefieldBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.littlefieldLunch.value!!, "lunch")
            val dinner = getJson(viewModel.littlefieldDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Littlefield Cafe")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }

        val cypressbendButton = findViewById<Button>(R.id.cypressbendbutton)
        cypressbendButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.cypressBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.cypressLunch.value!!, "lunch")
            val dinner = getJson(viewModel.cypressDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Cypress Bend Cafe")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }

        val jcmButton = findViewById<Button>(R.id.jcmbutton)
        jcmButton.setOnClickListener {
            val intent = Intent(this, DiningHallActivity::class.java)
            val breakfast = getJson(viewModel.jcmBreakfast.value!!, "breakfast")
            val lunch = getJson(viewModel.jcmLunch.value!!, "lunch")
            val dinner = getJson(viewModel.jcmDinner.value!!, "dinner")
            intent.putExtra("diningHallName", "Jester City Market")
            intent.putExtra("breakfast", breakfast)
            intent.putExtra("lunch", lunch)
            intent.putExtra("dinner", dinner)
            startActivity(intent)
        }
    }

    // Return the FoodData objects as a string for extra packing
    private fun getJson(data: List<FoodData>, mealType: String): String {
        val emptyListJsonString: String = """[{"name":"Food Not Served","category":"This dining hall is not serving $mealType today.","link":"https://www.youtube.com/watch?v=dQw4w9WgXcQ"}]"""

        Log.d("getJson", "processing $data")
        val jsonList = when (Json.encodeToString(data)) {
            "null" -> emptyListJsonString
            "[]" -> emptyListJsonString
            else -> Json.encodeToString(data)
        }

        return jsonList
    }

    private fun toggleDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}