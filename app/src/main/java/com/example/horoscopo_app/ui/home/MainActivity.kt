package com.example.horoscopo_app.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.horoscopo_app.R
import com.example.horoscopo_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //View Binding
    private lateinit var binding: ActivityMainBinding

    //Controlador de Pantallas
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initNavigation()
    }

    private fun initNavigation() {

        //Las pantallas se alojan en el Host
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        //El controlador, tiene que obtener las pantallas
        navController = navHost.navController
        //Se le asigna a la vista (bottom nav bar) el controlador para obtener las pantallas
        binding.btnNavBar.setupWithNavController(navController)

    }
}