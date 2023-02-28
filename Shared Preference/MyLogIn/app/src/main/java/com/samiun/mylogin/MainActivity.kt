package com.samiun.mylogin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.samiun.mylogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val sharedPreFile = "Kotlin Shared Preferenc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences: SharedPreferences =
            this.getSharedPreferences(sharedPreFile, Context.MODE_PRIVATE)
        val sharedName = sharedPreferences.getString(Constant.name, "my name")
        val sharedPassword = sharedPreferences.getString(Constant.password, "*****")

        if (sharedName != null) {
            if (sharedName != "my name" && sharedName.isNotEmpty()) {
                intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(Constant.name, sharedName.toString())
                startActivity(intent)

            }
        }


        binding.btnsave.setOnClickListener {
            val name = binding.personName.text.toString()
            val password = binding.etPassword.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(Constant.name, name)
                editor.putString(Constant.password, password)
                editor.apply()
            }

        }

        binding.btnview.setOnClickListener {
            val sharedName = sharedPreferences.getString(Constant.name, "my name")
            val sharedPassword = sharedPreferences.getString(Constant.password, "*****")
            binding.tvName.isVisible = true
            binding.tvPassword.isVisible = true

            binding.tvName.setText("Name :${sharedName}")
            binding.tvPassword.setText("Password : $sharedPassword")
        }

    }
}