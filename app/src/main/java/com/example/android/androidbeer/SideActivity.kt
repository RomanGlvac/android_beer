package com.example.android.androidbeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.androidbeer.databinding.ActivitySideBinding

class SideActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userAnswer = intent.getStringExtra("userAnswer")
        binding.userAnswerTextView.text = userAnswer
    }
}