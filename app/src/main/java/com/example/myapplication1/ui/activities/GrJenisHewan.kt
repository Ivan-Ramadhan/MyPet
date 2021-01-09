package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_gr_jenis_hewan2.*

class GrJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_jenis_hewan2)

        btn_gr_cat.setOnClickListener {

            val pindah = Intent(this@GrJenisHewan, GrDaftarPelayanan::class.java)
                .apply {
                    putExtra(Constants.PET, Constants.CAT)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }

        btn_gr_dog.setOnClickListener {

            val pindah = Intent(this@GrJenisHewan, GrLayananAnjing::class.java)
                .apply {

                }

            startActivity(pindah)
        }
    }


}
