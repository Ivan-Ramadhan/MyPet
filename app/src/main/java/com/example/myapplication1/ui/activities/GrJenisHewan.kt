package com.example.myapplication1.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_gr_jenis_hewan2.*

class GrJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_jenis_hewan2)

        buttonKucing.setOnClickListener {

            val pindah = Intent(this@GrJenisHewan, GrDaftarPelayanan::class.java)
                .apply {

                }

            startActivity(pindah)
        }

    }


}
