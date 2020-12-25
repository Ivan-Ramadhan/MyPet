package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.ui.adapters.DashboardItemsListAdapter
import com.example.myapplication1.utils.Constants
import com.myshoppal.models.Product
import kotlinx.android.synthetic.main.activity_cat_wet_food.*

class CatWetFoodActivity : BaseActivity() {
//    private val context: Context = this.activi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_wet_food)

        setupActionBar()
    }
    private fun setupActionBar() {

        setSupportActionBar(toolbar_catwetfood_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_catwetfood_activity.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onResume() {
        super.onResume()

        getCatwetfoodItemsList()
    }
    private fun getCatwetfoodItemsList() {
        // Show the progress dialog.
        showProgressDialog(resources.getString(R.string.please_wait))

        FirestoreClass().getCatwetfoodItemsList(this@CatWetFoodActivity)
    }


    fun successCatwetfoodItemsList(catwetfoodItemsList: ArrayList<Product>) {

        // Hide the progress dialog.
        hideProgressDialog()
        for(i in catwetfoodItemsList){
            Log.i("Item title", i.title)
        }

        if (catwetfoodItemsList.size > 0) {

            rv_catwetfood_items.visibility = View.VISIBLE
            tv_no_catwetfood_items_found.visibility = View.GONE

            rv_catwetfood_items.layoutManager = GridLayoutManager(this, 2)
            rv_catwetfood_items.setHasFixedSize(true)

            val adapter = DashboardItemsListAdapter(this, catwetfoodItemsList)
            rv_catwetfood_items.adapter = adapter

            adapter.setOnClickListener(object :
                DashboardItemsListAdapter.OnClickListener {
                override fun onClick(position: Int, product: Product) {

                    val intent = Intent(this@CatWetFoodActivity, ProductDetailsActivity::class.java)
                    intent.putExtra(Constants.EXTRA_PRODUCT_ID, product.product_id)
                    startActivity(intent)
                    // END
                }
            })

        } else {
            rv_catwetfood_items.visibility = View.GONE
            tv_no_catwetfood_items_found.visibility = View.VISIBLE
        }
    }


}