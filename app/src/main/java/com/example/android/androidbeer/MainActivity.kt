package com.example.android.androidbeer

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.androidbeer.databinding.ActivityMainBinding
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.tools.JsonLoader
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener : NavController.OnDestinationChangedListener

    private var _pubHolder : PubHolder? = null
    val pubHolder get() = _pubHolder!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigationDrawer()
        loadPubList()
    }

    override fun onSupportNavigateUp(): Boolean {
        var navController : NavController? = null
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }
        if (navController != null) {
            return navController.navigateUp(appBarConfiguration)
        }
        return super.onSupportNavigateUp()
    }

    private fun setupNavigationDrawer(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun loadPubList(){
        val json = JsonLoader.openJson(applicationContext, "pubs.json")!!
        _pubHolder = Gson().fromJson(json, PubHolder::class.java)
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause() called.")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop() called.")
    }

}