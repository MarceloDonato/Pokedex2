package com.marcelo.pokedex2.splash


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.onboarding.OnboardingActitivy
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    val background = intArrayOf(
        R.drawable.time1,
        R.drawable.time2,
        R.drawable.time3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getRandomBackground(applicationContext)
        Handler().postDelayed({
            startWelcomeScreen()

        }, 3000.toLong())
    }

    private fun getRandomBackground(context: Context) {
        splash_background.background = ContextCompat.getDrawable(context, background.random())
    }

    private fun startWelcomeScreen() {
        startActivity(OnboardingActitivy.getStartIntent(this))
        finish()
    }

}