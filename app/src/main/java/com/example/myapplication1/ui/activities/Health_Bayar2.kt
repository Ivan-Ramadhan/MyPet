package com.example.myapplication1.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_health__bayar2.*

class Health_Bayar2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health__bayar2)

        button3.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_Konsultasi::class.java)
            startActivity(intent);
        })

    }
}