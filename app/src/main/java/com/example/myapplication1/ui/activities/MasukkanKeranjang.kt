package com.example.myapplication1.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_masukkan_keranjang.*

class MasukkanKeranjang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masukkan_keranjang)
        buttonMasukkanKeranjang.setOnClickListener {

            val pindah = Intent(this@MasukkanKeranjang, MainActivity::class.java)
                .apply {

                }

            startActivity(pindah)
        }
    }
}