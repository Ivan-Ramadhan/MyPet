package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_gr_daftar_pelayanan.*
import kotlinx.android.synthetic.main.activity_gr_jenis_hewan2.*
import kotlinx.android.synthetic.main.activity_gr_keranjang.*


class GrDaftarPelayanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_daftar_pelayanan)

        buttonCukur.setOnClickListener {

            val pindah = Intent(this@GrDaftarPelayanan, GrKeranjang::class.java)
                .apply {

                }

            startActivity(pindah)
        }

    }


}