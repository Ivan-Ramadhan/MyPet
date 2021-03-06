package com.example.myapplication1.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication1.R
import com.example.myapplication1.ui.activities.*
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
        val tvfood: TextView? = root.findViewById(R.id.tv_food)
        val tvaccessories: TextView? = root.findViewById(R.id.tv_accessories)
        val tvgrooming: TextView? = root.findViewById(R.id.tv_grooming)
        val tvdaycare: TextView? = root.findViewById(R.id.tv_day_care)
        val tvhealthcare: TextView? = root.findViewById(R.id.tv_health_care)
//        textView.text = "This is home Fragment"
        tvfood?.setOnClickListener(this)
        tvaccessories?.setOnClickListener(this)
        tvgrooming?.setOnClickListener(this)
        tvdaycare?.setOnClickListener(this)
        tvhealthcare?.setOnClickListener(this)
        val tv_Usermain : TextView = root.findViewById(R.id.tv_Usermain)

        val sharedPreferences =
            activity?.getSharedPreferences(Constants.MYPET_PREFERENCES, Context.MODE_PRIVATE)

        val username = sharedPreferences?.getString(Constants.LOGGED_IN_USERNAME, "")
        // Set the result to the tv_main.
        tv_Usermain.text= "Hello $username"



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

            R.id.action_cart -> {
                startActivity(Intent(activity, CartListActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.tv_food -> {
                    var tagMakanan = "Pilih Jenis Hewan"
                    val intent = Intent(activity, PilihJenisHewan::class.java)
                        .apply {
                            putExtra("makanan",tagMakanan)
                            putExtra(Constants.PRODUCT_TYPE,Constants.FOOD)
                     }
                    activity?.startActivity(intent)
                }

                R.id.tv_accessories -> {

                    val intent = Intent(activity, AksesorisJenisHewan::class.java)
                        .apply {
                            putExtra(Constants.PRODUCT_TYPE,Constants.ACCESSORIES)
                        }
                    activity?.startActivity(intent)

                }
                R.id.tv_grooming -> {

                    val intent = Intent(activity, GrJenisHewan::class.java)
                        .apply {
                            putExtra(Constants.PRODUCT_TYPE,Constants.GROOMING)
                        }
                    activity?.startActivity(intent)
                }

                R.id.tv_day_care -> {

                    val intent = Intent(activity, PenitipanJenisHewan::class.java)
                        .apply {
                            putExtra(Constants.PRODUCT_TYPE,Constants.DAY_CARE)
                        }
                    activity?.startActivity(intent)
                }
                R.id.tv_health_care -> {

                    val intent = Intent(activity, Health_JenisHewan::class.java)
                        .apply {
                            putExtra(Constants.PRODUCT_TYPE,Constants.HEALTH_CARE)
                        }
                    activity?.startActivity(intent)
                }
            }
        }
    }

}