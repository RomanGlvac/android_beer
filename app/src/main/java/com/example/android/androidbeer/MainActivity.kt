package com.example.android.androidbeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animationView : LottieAnimationView = findViewById(R.id.animationView)
        animationView.setOnClickListener {
            playAnimation(it as LottieAnimationView)
        }

    }

    private fun playAnimation(view : LottieAnimationView){
        if (view.progress == 1.0f){
            view.progress = 0.0f
        } else {
            view.playAnimation()
        }
    }
}