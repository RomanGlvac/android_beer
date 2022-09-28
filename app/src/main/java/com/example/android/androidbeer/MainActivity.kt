package com.example.android.androidbeer

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.model.KeyPath

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animationView : LottieAnimationView = findViewById(R.id.animationView)

        animationView.setOnClickListener {
            playAnimation(it as LottieAnimationView)
        }

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            val textView : TextView = findViewById(R.id.instructionTextView)

            override fun onAnimationStart(p0: Animator?) {
                textView.text = getString(R.string.filling_glass_instruciton)
            }

            override fun onAnimationEnd(p0: Animator?) {
                textView.text = getString(R.string.full_glass_instruction)
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}

        })

    }

    private fun playAnimation(view : LottieAnimationView){
        if (view.progress == 1.0f){
            view.progress = 0.0f
            findViewById<TextView>(R.id.instructionTextView).text = getString(R.string.empty_glass_instruction)
        } else {
            view.playAnimation()
        }
    }
}