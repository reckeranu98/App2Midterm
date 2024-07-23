package com.lu.app2midterm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val options = arrayOf("None", "Length", "Weight", "Temperature")
    val tempOptions = arrayOf("None", "Fahrenheit", "Celsius", "Kelvin")
    val lengthOptions = arrayOf("None", "cm", "inch")
    val weightOptions = arrayOf("None", "Kilogram", "gram", "milligram")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        val spOption: Spinner = findViewById(R.id.spOption)

        spOption.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, options)

        spOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                handleSpinnerSelection(position,context)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Nothing implemented")
            }
        }
    }

    fun handleSpinnerSelection(
        position: Int,
        context: Context
    ) {
        val value = options[position]

        //Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
        when (value) {
            "None" -> {
                Toast.makeText(context, "Choose an option", Toast.LENGTH_SHORT).show()
            }

            "Length" -> {
                val intent = Intent(context, LengthActivity::class.java)
                startActivity(intent)
                //Toast.makeText(context, "You choose length", Toast.LENGTH_SHORT).show()
            }

            "Weight" -> {
                val intent = Intent(context, WeightActivity::class.java)
                startActivity(intent)
                //Toast.makeText(context, "You choose weight", Toast.LENGTH_SHORT).show()
            }

            "Temperature" -> {

                val intent = Intent(context, TemperatureActivity::class.java)
                startActivity(intent)
                //Toast.makeText(context, "You choose temperature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

