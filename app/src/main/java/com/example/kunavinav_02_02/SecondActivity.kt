package com.example.kunavinav_02_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.kunavinav_02_02.databinding.ActivityMainBinding
import com.example.kunavinav_02_02.databinding.ActivitySecondBinding
import kotlin.math.pow

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinnerFrom.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.array_list))
        binding.spinnerFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {}

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
        val array = arrayListOf<Int>(1, 2, 3, 4)
        binding.spinnerTo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.array_list))
        binding.spinnerTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {}

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }

        binding.buttonResult.setOnClickListener {
            val number = binding.number.text.toString().toInt()
            val exp = array[binding.spinnerFrom.selectedItemId.toInt()] - array[binding.spinnerTo.selectedItemId.toInt()]

//            val result = if(exp < 0)  else if(exp > 0) number
            val result = (number * (10.0.pow(3 * exp.toDouble())))
            binding.result.setText(result.toString())

            val intent = Intent(this, FierdActivity::class.java)
            intent.putExtra("result", result.toString())
            startActivity(intent)
        }
    }
}