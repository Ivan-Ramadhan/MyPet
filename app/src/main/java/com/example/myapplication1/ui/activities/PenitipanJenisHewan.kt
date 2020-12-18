package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_penitipan_jenis_hewan.*
import kotlinx.android.synthetic.main.activity_penitipan_jenis_hewan.button18
import kotlinx.android.synthetic.main.activity_penitipan_pilih_toko.*

class PenitipanJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penitipan_jenis_hewan)

        buttonAnjiang.setOnClickListener {

            val pindah = Intent(this@PenitipanJenisHewan, PenitipanDurasi::class.java)
                .apply {
                }
            startActivity(pindah)
        }
    }
}