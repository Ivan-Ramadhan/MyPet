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
        setupActionBar()

        ll_gr_pet_cat.setOnClickListener {

            val pindah = Intent(this@GrJenisHewan, GrDaftarPelayanan::class.java)
                .apply {
                    putExtra(Constants.PET, Constants.CAT)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }

        ll_gr_pet_dog.setOnClickListener {

            val pindah = Intent(this@GrJenisHewan, GrLayananAnjing::class.java)
                .apply {
                    putExtra(Constants.PET, Constants.DOG)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_gr_pet)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_gr_pet.setNavigationOnClickListener { onBackPressed() }
    }

}
