package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_aksesoris_jenis_hewan.*


class AksesorisJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aksesoris_jenis_hewan)
        setupActionBar()

        ll_acc_pet_cat.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                AksesorisJenisBarang::class.java)
                .apply {
                    putExtra(Constants.PET, Constants.CAT)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent);
        })

        ll_acc_pet_dog.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                AksesorisJenisBarangAnjing::class.java)
                .apply {
                    putExtra(Constants.PET,Constants.DOG)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(intent);
        })

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_acc_pet)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }
        toolbar_acc_pet.setNavigationOnClickListener { onBackPressed() }
    }

}