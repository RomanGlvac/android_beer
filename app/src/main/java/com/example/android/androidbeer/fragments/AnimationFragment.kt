package com.example.android.androidbeer.fragments

import android.animation.Animator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.androidbeer.R
import com.example.android.androidbeer.databinding.FragmentAnimationBinding


class AnimationFragment : Fragment() {

    private var _binding : FragmentAnimationBinding? = null
    private val binding get() = _binding!!
    private val args : AnimationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimationBinding.inflate(inflater, container, false)
        setTextViews()
        setButtonListeners()
        setAnimationListeners()
        return binding.root
    }

    private fun setTextViews(){
        binding.tvUsername.text = args.userName
        binding.tvEstablishment.text = args.establishmentName
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

    private fun setButtonListeners(){
        binding.btnShowMap.setOnClickListener { openMap() }
    }

    private fun openMap(){
        val latitude : String = args.latitude
        val longitude : String = args.longitude
        val intent : Intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$latitude,$longitude"))
        startActivity(intent)
    }

}