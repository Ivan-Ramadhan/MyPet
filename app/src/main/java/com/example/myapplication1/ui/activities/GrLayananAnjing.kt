package com.example.myapplication1.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_gr_daftar_pelayanan.*
import kotlinx.android.synthetic.main.activity_gr_daftar_pelayanan.btn_gr_cat_haircut
import kotlinx.android.synthetic.main.activity_gr_layanan_anjing.*

class GrLayananAnjing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_layanan_anjing)

        buttonCukurAnjing.setOnClickListener {

            val pindah = Intent(this@GrLayananAnjing, GrKeranjang::class.java)
                .apply {

                }

            startActivity(pindah)
        }
        buttonPotongKukuAnjing.setOnClickListener {

            val pindah = Intent(this@GrLayananAnjing, GrKeranjang::class.java)
                .apply {

                }

            startActivity(pindah)
        }
        buttonPerawatanAnjing.setOnClickListener {

            val pindah = Intent(this@GrLayananAnjing, GrKeranjang::class.java)
                .apply {

                }

            startActivity(pindah)
        }
    }
}