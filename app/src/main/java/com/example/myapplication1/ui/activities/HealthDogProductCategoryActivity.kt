package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_health_dog_product_category.*

class HealthDogProductCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_dog_product_category)
        setupActionBar()
        ll_dog_vitamins.setOnClickListener{

            val move = Intent(this@HealthDogProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_VITAMINS)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_dog_suplements.setOnClickListener{

            val move = Intent(this@HealthDogProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_SUPLEMENTS)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_dog_medicine.setOnClickListener{

            val move = Intent(this@HealthDogProductCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_MEDICINE)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_dog_health_category)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_dog_health_category.setNavigationOnClickListener { onBackPressed() }
    }
}