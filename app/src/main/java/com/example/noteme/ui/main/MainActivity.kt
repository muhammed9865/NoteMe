package com.example.noteme.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteme.R
import com.example.noteme.databinding.ActivityMainBinding
import com.example.noteme.utils.ScreenSlidePageAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        // Navcontroller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.mainToolbar, navController)
        //NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                // changes on fragments done here
                R.id.homeFragment -> {
                  //  supportActionBar?.hide()
                }
                R.id.allFragment -> {
                 //   supportActionBar?.show()

                }
                R.id.favouritesFragment -> {
                  //  supportActionBar?.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val appBarConfig = AppBarConfiguration(navController.graph)
        return NavigationUI.navigateUp(navController, appBarConfig)
    }


}