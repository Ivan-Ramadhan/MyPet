package com.example.myapplication1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication1.R


class ProductsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  //      dashboardViewModel =
  //          ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_products, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)

        textView.text = "This is dashboard Fragment"

        return root
    }
}