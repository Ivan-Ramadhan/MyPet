package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_aksesoris_jenis_barang.*

class AksesorisJenisBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aksesoris_jenis_barang)
        setupActionBar()

        button13.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_GLASSES)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })

        button9.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.CAT_CLOTHES)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })

        button22.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.CAT_NECKBELT)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })

        button23.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.CAT_HAT)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })

        button25.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY,Constants.CAT_SHOES)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_acc_cat_category)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_acc_cat_category.setNavigationOnClickListener { onBackPressed() }
    }
}