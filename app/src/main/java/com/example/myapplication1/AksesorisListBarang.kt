package com.example.myapplication1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_aksesoris_list_barang.*

class AksesorisListBarang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aksesoris_list_barang)

        button14.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,Aksesoriskeranjang::class.java)
            startActivity(intent);
        })

    }

}