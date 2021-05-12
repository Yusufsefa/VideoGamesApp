package com.yyusufsefa.videogamesapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.yyusufsefa.videogamesapp.R
import com.yyusufsefa.videogamesapp.common.BaseFragment
import com.yyusufsefa.videogamesapp.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.side_slide)
        binding.splash.startAnimation(slideAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_home)
        }, 3000)
    }
}