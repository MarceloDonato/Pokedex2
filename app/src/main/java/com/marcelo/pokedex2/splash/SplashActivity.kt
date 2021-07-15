package com.marcelo.pokedex2.splash

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.onboarding.OnboardingActitivy
import com.marcelo.pokedex2.view.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        showLogoPokemonSplash()
    }

    private fun showLogoPokemonSplash(){
      logo_pokemon.addAnimatorListener( object :
        Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator?) {}

            override fun onAnimationEnd(animator: Animator) {
                startWelcomeScreen()
            }

          override fun onAnimationCancel(animation: Animator?) {}
          override fun onAnimationRepeat(animation: Animator?) {}

      })
    }

    private fun startWelcomeScreen(){

        startActivity(OnboardingActitivy.getStartIntent(this))
        finish()

    }
}