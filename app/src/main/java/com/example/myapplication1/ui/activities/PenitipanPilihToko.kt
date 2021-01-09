package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_aksesoris_jenis_barang.*
import kotlinx.android.synthetic.main.activity_gr_jenis_hewan2.*
import kotlinx.android.synthetic.main.activity_penitipan_pilih_toko.*

class PenitipanPilihToko : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penitipan_pilih_toko)

        button18.setOnClickListener {

            val pindah = Intent(this@PenitipanPilihToko, PenitipanJenisHewan::class.java)
                .apply {
                }
            startActivity(pindah)
        }

        button19.setOnClickListener {

            val pindah = Intent(this@PenitipanPilihToko, PenitipanJenisHewan::class.java)
                .apply {
                }
            startActivity(pindah)
            }
        button20.setOnClickListener {

            val pindah = Intent(this@PenitipanPilihToko, PenitipanJenisHewan::class.java)
                .apply {
                }
            startActivity(pindah)
        }
    }
}