package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_gr_layanan_anjing.*

class GrLayananAnjing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gr_layanan_anjing)

        btn_gr_dog_haircut.setOnClickListener {

            val intent = Intent(this@GrLayananAnjing, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_HAIR_CUT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }

        btn_gr_dog_nailcut.setOnClickListener {

            val intent = Intent(this@GrLayananAnjing, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_NAIL_CUT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }

        btn_gr_dog_hairtreatment.setOnClickListener {

            val intent = Intent(this@GrLayananAnjing, CatWetFoodActivity::class.java)
                .apply {
                    putExtra(Constants.PRODUCT_CATEGORY, Constants.DOG_HAIR_TREATMENT)
                    putExtra(Constants.PET, intent.getStringExtra(Constants.PET))
                    putExtra(Constants.PRODUCT_TYPE, intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent)
        }
    }
}