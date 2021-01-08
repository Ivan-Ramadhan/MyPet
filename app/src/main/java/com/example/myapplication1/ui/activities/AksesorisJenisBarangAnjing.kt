package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_aksesoris_jenis_barang.*
import kotlinx.android.synthetic.main.activity_aksesoris_jenis_barang_anjing.*


class AksesorisJenisBarangAnjing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aksesoris_jenis_barang_anjing)

        button39.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesorisbajuanjing::class.java)
            startActivity(intent);
        })

        button40.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesoriskalunganjing::class.java)
            startActivity(intent);
        })

        button41.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesoristopianjing::class.java)
            startActivity(intent);
        })

        button42.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesoriskacamataanjing::class.java)
            startActivity(intent);
        })

        button43.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Aksesorissepatuanjing::class.java)
            startActivity(intent);
        })

    }
}