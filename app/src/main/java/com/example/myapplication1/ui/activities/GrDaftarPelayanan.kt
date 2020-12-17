package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_gr_daftar_pelayanan.*


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