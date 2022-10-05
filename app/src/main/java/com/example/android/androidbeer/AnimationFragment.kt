package com.example.android.androidbeer

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.androidbeer.databinding.FragmentAnimationBinding


class AnimationFragment : Fragment() {

    private var _binding : FragmentAnimationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimationBinding.inflate(inflater, container, false)
        setAnimationListeners()
        return binding.root
    }

    private fun setAnimationListeners(){
        // Click listener.
        binding.animationView.setOnClickListener { playAnimation() }

        // Animation listener.
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                binding.instructionTextView.text = getString(R.string.full_glass_instruction)
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}
        })
    }

    private fun playAnimation(){
        if (binding.animationView.progress == 1.0f){
            binding.animationView.progress = 0.0f
            binding.instructionTextView.text = getString(R.string.empty_glass_instruction)
        } else {
            binding.animationView.playAnimation()
            binding.instructionTextView.text = getString(R.string.filling_glass_instruction)
        }
    }

}