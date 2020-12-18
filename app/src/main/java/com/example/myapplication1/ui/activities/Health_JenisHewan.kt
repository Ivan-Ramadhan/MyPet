package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_health__jenis_hewan.*


class Health_JenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health__jenis_hewan)

        button4.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_ListDokter::class.java)
            startActivity(intent);
        })

        button16.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_ListDokter::class.java)
            startActivity(intent);
        })
    }
}