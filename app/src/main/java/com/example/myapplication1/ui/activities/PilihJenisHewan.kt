package com.example.myapplication1.ui.activities
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_pilih_jenis_hewan.*

class PilihJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jenis_hewan)

        txtJudul.text = intent.getStringExtra("makanan")

        buttonMknKucing.setOnClickListener{

            val pindah = Intent(this@PilihJenisHewan, PilihJenisMakanan::class.java)
                .apply {

                }

            startActivity(pindah)
    }

}


}