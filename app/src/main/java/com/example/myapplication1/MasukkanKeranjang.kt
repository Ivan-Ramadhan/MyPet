package com.example.myapplication1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_masukkan_keranjang.*
import kotlinx.android.synthetic.main.activity_pilih_jenis_hewan.*

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