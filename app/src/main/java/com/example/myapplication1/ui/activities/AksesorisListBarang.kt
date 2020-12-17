package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_aksesoris_list_barang.*

class AksesorisListBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aksesoris_list_barang)

        button14.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesoriskeranjang::class.java)
            startActivity(intent);
        })

    }

}