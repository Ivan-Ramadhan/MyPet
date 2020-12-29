package com.example.myapplication1.ui.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.models.Address
import com.example.myapplication1.models.CartItem
import com.example.myapplication1.ui.adapters.CartItemsListAdapter
import com.example.myapplication1.utils.Constants
import com.myshoppal.models.Product
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : BaseActivity() {

    private var mAddressDetails: Address? = null

    private lateinit var mProductsList: ArrayList<Product>

    private lateinit var mCartItemsList: ArrayList<CartItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        setupActionBar()

        if (intent.hasExtra(Constants.EXTRA_SELECTED_ADDRESS)) {
            mAddressDetails =
                intent.getParcelableExtra<Address>(Constants.EXTRA_SELECTED_ADDRESS)!!
        }

        if (mAddressDetails != null) {
            tv_checkout_address_type.text = mAddressDetails?.type
            tv_checkout_full_name.text = mAddressDetails?.name
            tv_checkout_address.text = "${mAddressDetails!!.address}, ${mAddressDetails!!.zipCode}"
            tv_checkout_additional_note.text = mAddressDetails?.additionalNote

            if (mAddressDetails?.otherDetails!!.isNotEmpty()) {
                tv_checkout_other_details.text = mAddressDetails?.otherDetails
            }
            tv_checkout_mobile_number.text = mAddressDetails?.mobileNumber
        }

        getProductList()

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_checkout_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_checkout_activity.setNavigationOnClickListener { onBackPressed() }
    }


    private fun getProductList() {

        showProgressDialog(resources.getString(R.string.please_wait))

        FirestoreClass().getAllProductsList(this@CheckoutActivity)
    }

    fun successProductsListFromFireStore(productsList: ArrayList<Product>) {

        mProductsList = productsList

        getCartItemsList()

    }

    private fun getCartItemsList() {

        FirestoreClass().getCartList(this@CheckoutActivity)
    }

    fun successCartItemsList(cartList: ArrayList<CartItem>) {

        hideProgressDialog()

        for (product in mProductsList) {
            for (cartItem in cartList) {
                if (product.product_id == cartItem.product_id) {
                    cartItem.stock_quantity = product.stock_quantity
                }
            }
        }

        mCartItemsList = cartList

        rv_cart_list_items.layoutManager = LinearLayoutManager(this@CheckoutActivity)
        rv_cart_list_items.setHasFixedSize(true)

        val cartListAdapter = CartItemsListAdapter(this@CheckoutActivity, mCartItemsList, false)
        rv_cart_list_items.adapter = cartListAdapter

        var subTotal: Double = 0.0

        for (item in mCartItemsList) {

            val availableQuantity = item.stock_quantity.toInt()

            if (availableQuantity > 0) {
                val price = item.price.toDouble()
                val quantity = item.cart_quantity.toInt()

                subTotal += (price * quantity)
            }
        }

        tv_checkout_sub_total.text = "Rp$subTotal"
        // Here we have kept Shipping Charge is fixed as $10 but in your case it may cary. Also, it depends on the location and total amount.
        tv_checkout_shipping_charge.text = "RP1000.0"

        if (subTotal > 0) {
            ll_checkout_place_order.visibility = View.VISIBLE

            val total = subTotal + 10
            tv_checkout_total_amount.text = "Rp$total"
        } else {
            ll_checkout_place_order.visibility = View.GONE
        }


    }


}