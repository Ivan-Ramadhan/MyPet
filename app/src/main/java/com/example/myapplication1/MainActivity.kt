
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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMenuMakanan.setOnClickListener{
            var tagMakanan = "Pilih Jenis Hewan"

            val pindah = Intent(this@MainActivity, PilihJenisHewan::class.java)
                .apply {
                    putExtra("makanan",tagMakanan)
                }

            startActivity(pindah)

        }
        buttonGrooming.setOnClickListener{

            val pindah = Intent(this@MainActivity, GrJenisHewan::class.java)
                .apply {

                }

            startActivity(pindah)

            startActivity(pindah)

        }

        var button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(View.OnClickListener {
            var intent = Intent(this,AksesorisJenisHewan::class.java)
            startActivity(intent);
        })

        }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}