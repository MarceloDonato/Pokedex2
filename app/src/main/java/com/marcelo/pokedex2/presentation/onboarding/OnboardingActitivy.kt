package com.marcelo.pokedex2.presentation.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.presentation.view.MainActivity
import kotlinx.android.synthetic.main.activity_onboarding_actitivy.*

class OnboardingActitivy : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, OnboardingActitivy::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_actitivy)

        start_home_button.setOnClickListener{
            startActivity(MainActivity.getStartIntent(this))
            finish()
        }

    }

}