package com.example.myapplication1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.graphics.Typeface
import java.lang.reflect.Type

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                // Launch Main Activity
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()

            }, 1500
        )


    }
}