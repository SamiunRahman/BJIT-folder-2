package com.samiun.mynews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.samiun.mynews.BookmarkFragmentDirections
import com.samiun.mynews.R
import com.samiun.mynews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
      //  val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
        binding!!.bottomNav.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home_bottom_nav -> {
                    navController.navigate(R.id.homeFragment)

                    Toast.makeText(this, "Home Nav Clicked", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                R.id.bookmarks_bottom_nav -> {
                    navController.navigate(R.id.bookmarkFragment)

                    return@setOnItemSelectedListener true
                }

            }
            false
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}