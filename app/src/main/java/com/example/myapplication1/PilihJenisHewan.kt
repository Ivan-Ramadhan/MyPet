package com.example.myapplication1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pilih_jenis_hewan.*

class PilihJenisHewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_jenis_hewan)

        txtJudul.text = intent.getStringExtra("makanan")

        buttonAnjing.setOnClickListener{

            val pindah = Intent(this@PilihJenisHewan, PilihJenisMakanan::class.java)
                .apply {

                }

            startActivity(pindah)
    }

}


}