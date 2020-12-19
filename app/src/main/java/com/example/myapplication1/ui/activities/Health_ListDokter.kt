package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_health__list_dokter.*

class Health_ListDokter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health__list_dokter)

        eTTMFirdi.isEnabled = false
        eTTMMigent.isEnabled = false
        eTTMIvan.isEnabled = false


        button18.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_ProfilDokter1::class.java)
            startActivity(intent);
        })

        button17.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_ProfilDokter2::class.java)
            startActivity(intent);
        })

        button8.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,
                Health_ProfilDokter3::class.java)
            startActivity(intent);
        })
    }
}