package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.models.Product
import com.example.myapplication1.ui.adapters.DashboardItemsListAdapter
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_cat_wet_food.*

class CatWetFoodActivity : BaseActivity() {
//    private val context: Context = this.activi
    private var mProductCategory : String = ""
    lateinit var product: Product
    private var mProductType : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_wet_food)
        tv_title.text = intent.getStringExtra(Constants.PRODUCT_CATEGORY)
        mProductCategory = intent.getStringExtra(Constants.PRODUCT_CATEGORY).toString()
        mProductType = intent.getStringExtra(Constants.PRODUCT_TYPE).toString()
        setupActionBar()

        product = Product(
            category = intent.getStringExtra(Constants.PRODUCT_CATEGORY).toString(),
            pet = intent.getStringExtra(Constants.PET).toString(),
            type = intent.getStringExtra(Constants.PRODUCT_TYPE).toString()

        )


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

        FirestoreClass().getCatwetfoodItemsList(this@CatWetFoodActivity,product)
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

            if(mProductType.equals(Constants.GROOMING) || mProductType.equals(Constants.DAY_CARE))
            rv_catwetfood_items.layoutManager = GridLayoutManager(this, 1)
            else{
                rv_catwetfood_items.layoutManager = GridLayoutManager(this, 2)
            }

            rv_catwetfood_items.setHasFixedSize(true)

            val adapter = DashboardItemsListAdapter(this, catwetfoodItemsList)
            rv_catwetfood_items.adapter = adapter

            adapter.setOnClickListener(object :
                DashboardItemsListAdapter.OnClickListener {
                override fun onClick(position: Int, product: Product) {

                    val intent = Intent(this@CatWetFoodActivity, ProductDetailsActivity::class.java)
                    intent.putExtra(Constants.EXTRA_PRODUCT_ID, product.product_id)
                    intent.putExtra(Constants.EXTRA_PRODUCT_OWNER_ID, product.user_id)
                    startActivity(intent)

                }
            })

        } else {
            rv_catwetfood_items.visibility = View.GONE
            tv_no_catwetfood_items_found.visibility = View.VISIBLE
        }
    }


}