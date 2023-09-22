package com.example.ud01_2one_more_wine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonSearch = findViewById<Button>(R.id.button)
        buttonSearch.setOnClickListener {
            val spinnerWineTypes = findViewById<Spinner>(R.id.wineType)
            val texTypesWines = findViewById<TextView>(R.id.textTypesWines)
            texTypesWines.text = getWines(spinnerWineTypes.selectedItemId).joinToString("/n")
        }
    }
    fun getWines(id:Long) : List<String> = when (id){
        0L -> listOf("Albariño", "Moscato", "Verdejo")
        1L -> listOf("Rioja", "Ribera del duero", "Toro")
        3L -> listOf("Cabernet", "Franc", "Merlot")
        else -> listOf()
    }
}