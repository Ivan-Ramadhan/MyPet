package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_health_product_category.*

class HealthProductCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_product_category)

        setupActionBar()
        ll_cat_vitamins.setOnClickListener{

            val move = Intent(this@HealthProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_VITAMINS)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_cat_suplements.setOnClickListener{

            val move = Intent(this@HealthProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_SUPLEMENTS)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_cat_medicine.setOnClickListener{

            val move = Intent(this@HealthProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.CAT_MEDICINE)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_cat_health_category)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_cat_health_category.setNavigationOnClickListener { onBackPressed() }
    }
}