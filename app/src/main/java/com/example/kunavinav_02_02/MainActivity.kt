package com.example.kunavinav_02_02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.kunavinav_02_02.databinding.ActivityMainBinding
import com.example.kunavinav_02_02.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPrefs = this.getSharedPreferences("SHARED", Context.MODE_PRIVATE)
        if(sharedPrefs.contains("login") && sharedPrefs.contains("password")) startActivity(Intent(this, SecondActivity::class.java))
        binding.registerButton.setOnClickListener {
            if(binding.login.text.toString().isNotBlank() && binding.password.text.toString().isNotBlank()){
                with(sharedPrefs.edit()){
                    putString("login", binding.login.text.toString())
                    putString("password", binding.password.text.toString())
                    apply()
                }
                startActivity(Intent(this, SecondActivity::class.java))
            }
            else{
                AlertDialog.Builder(this).setTitle("Ошибка").setMessage("Поле логина или пароля пусты!").setPositiveButton("ОК"){
                    dialog, id -> dialog.cancel()
                }.show()
            }
        }
    }
}