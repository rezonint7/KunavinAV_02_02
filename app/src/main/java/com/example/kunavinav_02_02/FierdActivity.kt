package com.example.kunavinav_02_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kunavinav_02_02.databinding.ActivityFierdBinding
import com.example.kunavinav_02_02.databinding.ActivityMainBinding

class FierdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFierdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFierdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent.getStringExtra("result")
        binding.result.setText(result.toString())

        binding.registerButton.setOnClickListener {
            this@FierdActivity.deleteSharedPreferences("SHARED")
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}