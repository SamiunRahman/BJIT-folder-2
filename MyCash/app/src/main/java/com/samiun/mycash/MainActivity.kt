package com.samiun.mycash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var bottomMenu: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment

        navController = navHostFragment.findNavController()
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.home_menu, R.id.about_menu, R.id.logout_menu))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomMenu = findViewById(R.id.nav_menu)
        bottomMenu.setupWithNavController(navController)
        bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> {
                    val emailIntent = Intent(Intent.ACTION_SEND)
                    emailIntent.type = "message/rfc822"
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mycash@example.com"))
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customer Support Mail")
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "I having problem with the app regarding .......")

                    startActivity(Intent.createChooser(emailIntent, "Send email"))
                    true
                }
                R.id.about_menu -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.settingsFragment)
                    true
                }
                else -> {
                    finish()
                    true
                }
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }



}
