package com.example.android.androidbeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<LottieAnimationView>(R.id.animationView).setOnClickListener {
            playAnimation(it as LottieAnimationView)
        }
    }

    private fun playAnimation(view : LottieAnimationView){
        view.playAnimation()
    }
}