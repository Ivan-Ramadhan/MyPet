package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_gr_pilih_toko.*

class GrPilihToko : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_pilih_toko)

        buttonGorillaz.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                GrJenisHewan::class.java)
            startActivity(intent);
        })
        buttonLittle.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                GrJenisHewan::class.java)
            startActivity(intent);
        })
        buttonJBB.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                GrJenisHewan::class.java)
            startActivity(intent);
        })
        }

    }
