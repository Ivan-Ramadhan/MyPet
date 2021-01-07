package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_pilih_jenis_makanan.*

class PilihJenisMakanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jenis_makanan)

        setupActionBar()

        buttonMakananKering.setOnClickListener{

            val pindah = Intent(this@PilihJenisMakanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.DRY_FOOD)
                    putExtra(Constants.ANIMAL,intent.getStringExtra(Constants.ANIMAL))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
    }

        buttonMakananBasah.setOnClickListener{

            val pindah = Intent(this@PilihJenisMakanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.WET_FOOD)
                    putExtra(Constants.ANIMAL,intent.getStringExtra(Constants.ANIMAL))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }

        buttonSnack.setOnClickListener{

            val pindah = Intent(this@PilihJenisMakanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.SNACK)
                    putExtra(Constants.ANIMAL,intent.getStringExtra(Constants.ANIMAL))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }
}
    private fun setupActionBar() {

        setSupportActionBar(toolbar_mknjnmkn_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_mknjnmkn_activity.setNavigationOnClickListener { onBackPressed() }
    }
}