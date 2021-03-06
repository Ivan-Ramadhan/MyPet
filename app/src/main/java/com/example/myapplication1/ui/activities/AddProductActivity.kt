package com.example.myapplication1.ui.activities

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication1.R
import com.example.myapplication1.firestore.FirestoreClass
import com.example.myapplication1.models.Product
import com.example.myapplication1.utils.Constants
import com.example.myapplication1.utils.GlideLoader
import kotlinx.android.synthetic.main.activity_add_product.*
import java.io.IOException

class AddProductActivity : BaseActivity(), View.OnClickListener {
    private var mSelectedImageFileUri: Uri? = null

    private var mProductImageURL: String = ""

    private var mProductType : String = ""

    private var mProductCategory : String = ""

    private var mProductPet: String = ""

    lateinit var optionProductType : Spinner

    lateinit var optionProductCategory : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        setupActionBar()
        // Assign the click event to iv_add_update_product image.
        iv_add_update_product.setOnClickListener(this)

        // Assign the click event to submit button.
        btn_submit.setOnClickListener(this)


    }

    override fun onResume() {
        super.onResume()

        if(rb_cat.isChecked)
        {
            mProductPet = Constants.CAT
            spinnerProductType()
        }
        else if(rb_dog.isChecked) {
            mProductPet = Constants.DOG
            spinnerProductType()
        }
    }

    private fun spinnerProductType(){
        optionProductType = findViewById(R.id.sp_product_type) as Spinner
        val listType = arrayOf("Choose Product Type...","Food","Accessories","Grooming","Health Care","Day Care")

        optionProductType.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listType)
        optionProductType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                showErrorSnackBar(
                    resources.getString(R.string.err_msg_enter_product_type),
                    true
                )
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var listCategory: Array<String> = arrayOf()

               // FOOD
                if(listType.get(position).equals("Food") && rb_cat.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Wet Cat Food","Dry Cat Food","Snack Cat Food")
                }

                else if(listType.get(position).equals("Food") && rb_dog.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Wet Dog Food","Dry Dog Food","Snack Dog Food")
                }

                // Accessories
                else if(listType.get(position).equals("Accessories") && rb_cat.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Cat Clothes","Cat Neck Belt","Cat Hat","Cat Glasses","Cat Shoes")
                }

                else if(listType.get(position).equals("Accessories") && rb_dog.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Dog Clothes","Dog Neck Belt","Dog Hat","Dog Glasses","Dog Shoes")
                }

                // Grooming
                else if(listType.get(position).equals("Grooming") && rb_cat.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Cat Hair Cut","Cat Nail Cut","Cat Hair Treatment")
                }
                else if(listType.get(position).equals("Grooming") && rb_dog.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Dog Hair Cut","Dog Nail Cut","Dog Hair Treatment")
                }

                // Medicine
                else if(listType.get(position).equals("Health Care") && rb_cat.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Cat Vitamins","Cat Suplements","Cat Medicine")
                }
                else if(listType.get(position).equals("Health Care") && rb_dog.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Dog Vitamins","Dog Suplements","Dog Medicine")
                }

                // Daycare
                else if(listType.get(position).equals("Day Care") && rb_cat.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Cat Daily","Cat Weekly","Cat Monthly")
                }
                else if(listType.get(position).equals("Day Care") && rb_dog.isChecked)
                {
                    listCategory = arrayOf("Choose Product Category...","Dog Daily","Dog Weekly","Dog Monthly")
                }



                mProductType = listType.get(position).trim { it <= ' ' }
                spinnerProductCategory(listCategory)


            }
        }

    }

    private fun spinnerProductCategory(listCategory: Array<String>){
        optionProductCategory = findViewById(R.id.sp_product_category) as Spinner

        optionProductCategory.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listCategory)
        optionProductCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                showErrorSnackBar(
                    resources.getString(R.string.err_msg_enter_product_type),
                    true
                )
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    mProductCategory = listCategory.get(position)

            }
        }


    }



    private fun setupActionBar() {

        setSupportActionBar(toolbar_add_product_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_add_product_activity.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                // The permission code is similar to the user profile image selection.
                R.id.iv_add_update_product -> {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        )
                        == PackageManager.PERMISSION_GRANTED
                    ) {
                        Constants.showImageChooser(this@AddProductActivity)
                    } else {
                        /*Requests permissions to be granted to this application. These permissions
                         must be requested in your manifest, they should not be granted to your app,
                         and they should have protection level*/
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            Constants.READ_STORAGE_PERMISSION_CODE
                        )
                    }
                }

                R.id.btn_submit -> {
                    if (validateProductDetails()) {

                        uploadProductImage()
                    }
                }


            }
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Constants.READ_STORAGE_PERMISSION_CODE) {
            //If permission is granted
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Constants.showImageChooser(this@AddProductActivity)
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(
                    this,
                    resources.getString(R.string.read_storage_permission_denied),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK
            && requestCode == Constants.PICK_IMAGE_REQUEST_CODE
            && data!!.data != null
        ) {

            // Replace the add icon with edit icon once the image is selected.
            iv_add_update_product.setImageDrawable(
                ContextCompat.getDrawable(
                    this@AddProductActivity,
                    R.drawable.ic_vector_edit
                )
            )

            // The uri of selection image from phone storage.
            mSelectedImageFileUri = data.data!!

            try {
                // Load the product image in the ImageView.
                GlideLoader(this@AddProductActivity).loadUserPicture(
                    mSelectedImageFileUri!!,
                    iv_product_image
                )
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    private fun validateProductDetails(): Boolean {
        return when {

            mSelectedImageFileUri == null -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_select_product_image), true)
                false
            }

            TextUtils.isEmpty(et_product_title.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_product_title), true)
                false
            }

            TextUtils.isEmpty(et_product_price.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_product_price), true)
                false
            }

            TextUtils.isEmpty(et_product_description.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.err_msg_enter_product_description),
                    true
                )
                false
            }

            TextUtils.isEmpty(et_product_quantity.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(
                    resources.getString(R.string.err_msg_enter_product_quantity),
                    true
                )
                false
            }
            else -> {
                true
            }
        }
    }

    fun imageUploadSuccess(imageURL: String) {

        // Initialize the global image url variable.
        mProductImageURL = imageURL
        hideProgressDialog()

        uploadProductDetails()
    }

    private fun uploadProductImage() {

        showProgressDialog(resources.getString(R.string.please_wait))

        FirestoreClass().uploadImageToCloudStorage(
            this@AddProductActivity,
            mSelectedImageFileUri,
            Constants.PRODUCT_IMAGE
        )
    }

    private fun uploadProductDetails() {
        if(rb_cat.isChecked)
        {
            mProductPet = Constants.CAT

        }
        else if(rb_dog.isChecked) {
            mProductPet = Constants.DOG

        }
        // Get the logged in username from the SharedPreferences that we have stored at a time of login.
        val username =
            this.getSharedPreferences(Constants.MYPET_PREFERENCES, Context.MODE_PRIVATE)
                .getString(Constants.LOGGED_IN_USERNAME, "")!!

        // Here we get the text from editText and trim the space
        val product = Product(
            FirestoreClass().getCurrentUserID(),
            username,
            et_product_title.text.toString().trim { it <= ' ' },
            et_product_price.text.toString().trim { it <= ' ' },
            et_product_description.text.toString().trim { it <= ' ' },
            et_product_quantity.text.toString().trim { it <= ' ' },
            mProductImageURL,
            mProductType,
            mProductPet,
            mProductCategory
        )

        FirestoreClass().uploadProductDetails(this@AddProductActivity, product)
    }


    fun productUploadSuccess() {

        // Hide the progress dialog
        hideProgressDialog()

        Toast.makeText(
            this@AddProductActivity,
            resources.getString(R.string.product_uploaded_success_message),
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

}