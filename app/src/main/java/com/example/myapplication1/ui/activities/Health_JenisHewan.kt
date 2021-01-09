package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_health__jenis_hewan.*


class Health_JenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health__jenis_hewan)
        setupActionBar()

        ll_health_pet_cat.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                HealthProductCategoryActivity::class.java)
                .apply {
                    putExtra(Constants.PET, Constants.CAT)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent);
        })

        ll_health_pet_dog.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                HealthDogProductCategoryActivity::class.java)
                .apply {
                    putExtra(Constants.PET,Constants.DOG)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }
            startActivity(intent);
        })
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_health_pet)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_health_pet.setNavigationOnClickListener { onBackPressed() }
    }
}