package com.example.myapplication1.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_pilih_jenis_hewan.*

class PilihJenisMakanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jenis_makanan)

        buttonMakananKering.setOnClickListener{

            val pindah = Intent(this@PilihJenisMakanan, PilihBarang::class.java)
                .apply {

                }

            startActivity(pindah)

    }
}
}