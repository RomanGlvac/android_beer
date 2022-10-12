package com.example.android.androidbeer

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.model.KeyPath
import com.example.android.androidbeer.databinding.ActivityMainBinding
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.tools.JsonLoader
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var _pubHolder : PubHolder? = null
    val pubHolder get() = _pubHolder!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val json = JsonLoader.openJson(applicationContext, "pubs.json")!!
        _pubHolder = Gson().fromJson(json, PubHolder::class.java)
        setContentView(binding.root)
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