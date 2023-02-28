package com.samiun.mylogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.samiun.mylogin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val sharedPreFile = "Kotlin Shared Preferenc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPreFile, Context.MODE_PRIVATE)
        val sharedName = sharedPreferences.getString(Constant.name, "my name")
        Toast.makeText(this, "Welcome $sharedName", Toast.LENGTH_LONG).show()
        binding.homeText.text = "Welcome To Home Activity, $sharedName"
        binding.logOut.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}