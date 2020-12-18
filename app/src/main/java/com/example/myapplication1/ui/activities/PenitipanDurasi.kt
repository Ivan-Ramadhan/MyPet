package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_penitipan_durasi.*
import kotlinx.android.synthetic.main.activity_penitipan_pilih_toko.*

class PenitipanDurasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penitipan_durasi)

        buttonHarian.setOnClickListener {

            val pindah = Intent(this@PenitipanDurasi, PenitipanKeranjang::class.java)
                .apply {
                }
            startActivity(pindah)
        }
    }
}