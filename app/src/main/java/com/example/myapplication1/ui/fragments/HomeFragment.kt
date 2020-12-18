package com.example.myapplication1.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication1.R
import com.example.myapplication1.ui.activities.AksesorisJenisHewan
import com.example.myapplication1.ui.activities.GrJenisHewan
import com.example.myapplication1.ui.activities.PilihJenisHewan
import com.example.myapplication1.ui.activities.SettingsActivity
import com.example.myapplication1.utils.Constants


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // If we want to use the option menu in fragment we need to add it.
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  //      homeViewModel =
    //        ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
        val btnMakanan: Button? = root.findViewById(R.id.buttonMenuMakanan)
        val btnAksesoris: Button? = root.findViewById(R.id.buttonAksesoris)
        val btnGrooming: Button? = root.findViewById(R.id.buttonGrooming)
//        textView.text = "This is home Fragment"
        btnMakanan?.setOnClickListener(this)
        btnAksesoris?.setOnClickListener(this)
        btnGrooming?.setOnClickListener(this)
        val tv_Usermain : TextView = root.findViewById(R.id.tv_Usermain)

        val sharedPreferences =
            activity?.getSharedPreferences(Constants.MYPET_PREFERENCES, Context.MODE_PRIVATE)

        val username = sharedPreferences?.getString(Constants.LOGGED_IN_USERNAME, "")
        // Set the result to the tv_main.
        tv_Usermain.text= "Hello $username."



        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {

            R.id.action_settings -> {


                startActivity(Intent(activity, SettingsActivity::class.java))

                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.buttonMenuMakanan -> {
                    var tagMakanan = "Pilih Jenis Hewan"
                    val intent = Intent(activity, PilihJenisHewan::class.java)
                        .apply {
                        putExtra("makanan",tagMakanan)
                     }
                    activity?.startActivity(intent)
                }
                R.id.buttonAksesoris -> {

                    val intent = Intent(activity, AksesorisJenisHewan::class.java)
                    activity?.startActivity(intent)
                }
                R.id.buttonGrooming -> {

                    val intent = Intent(activity, GrJenisHewan::class.java)
                    activity?.startActivity(intent)
                }
            }
        }
    }

}