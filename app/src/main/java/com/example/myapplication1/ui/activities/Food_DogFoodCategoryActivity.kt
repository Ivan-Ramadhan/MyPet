package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_food__dog_food_category.*

class Food_DogFoodCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food__dog_food_category)
        setupActionBar()

        ll_dryfood.setOnClickListener{
            val move = Intent(this@Food_DogFoodCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DRY_DOG_FOOD)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_wetfood.setOnClickListener {
            val move = Intent(this@Food_DogFoodCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.WET_DOG_FOOD)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)
        }

        ll_snackfood.setOnClickListener {
            val move = Intent(this@Food_DogFoodCategoryActivity, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.SNACK_DOG_FOOD)
                    putExtra(Constants.PET,intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(move)

        }

    }


    private fun setupActionBar() {

        setSupportActionBar(toolbar_dogfoodcategory_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_dogfoodcategory_activity.setNavigationOnClickListener { onBackPressed() }
    }
}