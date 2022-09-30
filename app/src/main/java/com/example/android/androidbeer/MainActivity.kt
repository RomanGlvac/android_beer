package com.example.android.androidbeer

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.model.KeyPath
import com.example.android.androidbeer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animationView : LottieAnimationView = binding.animationView
        val submitBtn : Button = binding.submitButton

        animationView.setOnClickListener {
            playAnimation()
        }
        animationView.addAnimatorListener(
            object : Animator.AnimatorListener {
                val textView : TextView = binding.instructionTextView

                override fun onAnimationStart(p0: Animator?) {
                    textView.text = getString(R.string.filling_glass_instruciton)
                }

                override fun onAnimationEnd(p0: Animator?) {
                    textView.text = getString(R.string.full_glass_instruction)
                }

                override fun onAnimationCancel(p0: Animator?) {}

                override fun onAnimationRepeat(p0: Animator?) {}

            }
        )

        submitBtn.setOnClickListener{
            Intent(this, SideActivity::class.java).also {
                val userAnswer = binding.userAnswerEditText.text.toString()
                it.putExtra("EXTRA_USER_ANSWER", userAnswer)
                startActivity(it)
            }
        }


    }

    private fun playAnimation(){
        if (binding.animationView.progress == 1.0f){
            binding.animationView.progress = 0.0f
            binding.instructionTextView.text = getString(R.string.empty_glass_instruction)
        } else {
            binding.animationView.playAnimation()
        }
    }

}