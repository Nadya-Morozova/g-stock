package com.ndmrzzzv.giphystock.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.ndmrzzzv.giphystock.R
import com.ndmrzzzv.giphystock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment?.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(binding.navHostFragment.id)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}