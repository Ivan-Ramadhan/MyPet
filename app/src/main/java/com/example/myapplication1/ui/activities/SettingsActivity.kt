package com.example.myapplication1.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.models.User
import com.example.myapplication1.utils.Constants
import com.example.myapplication1.utils.GlideLoader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mUserDetails: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupActionBar()

        tv_edit.setOnClickListener(this@SettingsActivity)
        btn_logout.setOnClickListener(this@SettingsActivity)

        ll_address.setOnClickListener(this@SettingsActivity)
    }

    override fun onResume() {
        super.onResume()

        getUserDetails()
    }



    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {


                R.id.tv_edit -> {
                    val intent = Intent(this@SettingsActivity, UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS, mUserDetails)
                    startActivity(intent)
                }

                R.id.btn_logout -> {

                    FirebaseAuth.getInstance().signOut()

                    val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }

                R.id.ll_address -> {
                    val intent = Intent(this@SettingsActivity, AddressListActivity::class.java)
                    startActivity(intent)
                }

            }
        }
    }



    private fun setupActionBar() {

        setSupportActionBar(toolbar_settings_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_settings_activity.setNavigationOnClickListener { onBackPressed() }
    }

    private fun getUserDetails() {

        // Show the progress dialog
        showProgressDialog(resources.getString(R.string.please_wait))

        // Call the function of Firestore class to get the user details from firestore which is already created.
        FirestoreClass().getUserDetails(this@SettingsActivity)
    }

    fun userDetailsSuccess(user: User) {

        mUserDetails = user

        hideProgressDialog()

        GlideLoader(this@SettingsActivity).loadUserPicture(user.image, iv_user_photo)

        tv_name.text = "${user.firstName} ${user.lastName}"
        tv_gender.text = user.gender
        tv_email.text = user.email
        tv_mobile_number.text = "${user.mobile}"

    }




}