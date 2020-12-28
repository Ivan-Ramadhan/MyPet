package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.models.Address
import com.example.myapplication1.ui.adapters.AddressListAdapter
import kotlinx.android.synthetic.main.activity_address_list.*

class AddressListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)

        setupActionBar()

        tv_add_address.setOnClickListener {
            val intent = Intent(this@AddressListActivity, AddEditAddressActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        getAddressList()
    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar_address_list_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_address_list_activity.setNavigationOnClickListener { onBackPressed() }
    }

    private fun getAddressList() {

        showProgressDialog(resources.getString(R.string.please_wait))

        FirestoreClass().getAddressesList(this@AddressListActivity)
    }

    fun successAddressListFromFirestore(addressList: ArrayList<Address>) {

        hideProgressDialog()

        if (addressList.size > 0) {

            rv_address_list.visibility = View.VISIBLE
            tv_no_address_found.visibility = View.GONE

            rv_address_list.layoutManager = LinearLayoutManager(this@AddressListActivity)
            rv_address_list.setHasFixedSize(true)

            val addressAdapter = AddressListAdapter(this@AddressListActivity, addressList)
            rv_address_list.adapter = addressAdapter
        } else {
            rv_address_list.visibility = View.GONE
            tv_no_address_found.visibility = View.VISIBLE
        }


    }
}