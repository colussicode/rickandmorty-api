package com.example.rickandmorty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        loadSplashScreen()
    }

    private val handler = Handler()

    private fun loadSplashScreen() {
        handler.postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }
}