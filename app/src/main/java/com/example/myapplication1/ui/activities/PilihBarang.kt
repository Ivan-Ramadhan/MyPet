package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_pilih_barang.*

class PilihBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_barang)

        buttonItemMakanan1.setOnClickListener {

            val pindah = Intent(this@PilihBarang, MasukkanKeranjang::class.java)
                .apply {

                }

            startActivity(pindah)
        }
    }
}