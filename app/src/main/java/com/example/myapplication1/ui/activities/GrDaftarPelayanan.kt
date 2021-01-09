package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_gr_daftar_pelayanan.*


class GrDaftarPelayanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_daftar_pelayanan)

        setupActionBar()
        btn_gr_cat_haircut.setOnClickListener {

            val intent = Intent(this@GrDaftarPelayanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_HAIR_CUT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }

        btn_gr_cat_nailcut.setOnClickListener {

            val intent = Intent(this@GrDaftarPelayanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_NAIL_CUT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }

        btn_gr_cat_hairtreatment.setOnClickListener {

            val intent = Intent(this@GrDaftarPelayanan, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_HAIR_TREATMENT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_gr_cat_category)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_gr_cat_category.setNavigationOnClickListener { onBackPressed() }
    }

}