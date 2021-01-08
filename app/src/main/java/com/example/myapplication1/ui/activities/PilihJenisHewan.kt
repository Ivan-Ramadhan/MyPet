package com.example.myapplication1.ui.activities
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_pilih_jenis_hewan.*

class PilihJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jenis_hewan)

        txtJudul.text = intent.getStringExtra("makanan")

        buttonMknKucing.setOnClickListener{

            val pindah = Intent(this@PilihJenisHewan, PilihJenisMakanan::class.java)
                .apply {
                    putExtra(Constants.PET,Constants.CAT)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
    }

        buttonMknAnjing.setOnClickListener{

            val pindah = Intent(this@PilihJenisHewan, Food_DogFoodCategoryActivity::class.java)
                .apply {
                    putExtra(Constants.PET,Constants.DOG)
                    putExtra(Constants.PRODUCT_TYPE,intent.getStringExtra(Constants.PRODUCT_TYPE))
                }

            startActivity(pindah)
        }
        setupActionBar()

}

    private fun setupActionBar() {

        setSupportActionBar(toolbar_mknjnhewan_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_mknjnhewan_activity.setNavigationOnClickListener { onBackPressed() }
    }


}