package com.example.myapplication1.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap

object Constants {

    // Firebase Constants
    // Name of Collection in firstore
    const val USERS: String = "users"
    const val PRODUCTS: String = "products"

    const val MYPET_PREFERENCES: String = "MyPetPrefs"
    const val LOGGED_IN_USERNAME: String = "logged_in_username"

    const val EXTRA_USER_DETAILS: String = "extra_user_details"

    const val READ_STORAGE_PERMISSION_CODE = 2

    const val PICK_IMAGE_REQUEST_CODE = 1
    const val FIRST_NAME: String = "firstName"
    const val LAST_NAME: String = "lastName"

    const val MALE: String = "Male"
    const val FEMALE: String = "Female"

    const val MOBILE: String = "mobile"
    const val GENDER: String = "gender"

    const val IMAGE: String = "image"

    const val COMPLETE_PROFILE: String = "profileCompleted"

    const val USER_PROFILE_IMAGE: String = "User_Profile_Image"

    const val PRODUCT_IMAGE: String = "Product_Image"

    const val USER_ID: String = "user_id"

    const val EXTRA_PRODUCT_ID: String = "extra_product_id"

    const val EXTRA_PRODUCT_OWNER_ID: String = "extra_product_owner_id"

    const val DEFAULT_CART_QUANTITY: String = "1"

    const val CART_ITEMS: String = "cart_items"

    const val PRODUCT_ID: String = "product_id"

    const val CART_QUANTITY: String = "cart_quantity"

    const val HOME: String = "Home"
    const val OFFICE: String = "Office"
    const val OTHER: String = "Other"

    const val ADDRESSES: String = "addresses"

    const val EXTRA_ADDRESS_DETAILS: String = "AddressDetails"

    const val EXTRA_SELECT_ADDRESS: String = "extra_select_address"

    const val ADD_ADDRESS_REQUEST_CODE: Int = 121

    const val EXTRA_SELECTED_ADDRESS: String = "extra_selected_address"

    const val ORDERS: String = "orders"

    const val STOCK_QUANTITY: String = "stock_quantity"

    const val EXTRA_MY_ORDER_DETAILS: String = "extra_MY_ORDER_DETAILS"

    const val SOLD_PRODUCTS: String = "sold_products"

    const val EXTRA_SOLD_PRODUCT_DETAILS: String = "extra_sold_product_details"

    const val PET: String = "pet"

    const val CAT: String = "cat"

    const val DOG: String = "dog"

    const val PRODUCT_TYPE: String = "type"

    const val PRODUCT_CATEGORY: String = "category"

    const val FOOD: String = "Food"
    const val ACCESSORIES: String = "Accessories"
    const val HEALTH_CARE: String = "Health Care"
    const val DAY_CARE: String = "Day Care"
    const val GROOMING: String = "Grooming"


    const val DRY_CAT_FOOD: String = "Dry Cat Food"

    const val WET_CAT_FOOD: String = "Wet Cat Food"

    const val SNACK_CAT_FOOD: String = "Snack Cat Food"

    const val DRY_DOG_FOOD: String = "Dry Dog Food"

    const val WET_DOG_FOOD: String = "Wet Dog Food"

    const val SNACK_DOG_FOOD: String = "Snack Dog Food"

    const val CAT_CLOTHES: String = "Cat Clothes"
    const val CAT_NECKBELT: String = "Cat Neck Belt"
    const val CAT_HAT: String = "Cat Hat"
    const val CAT_GLASSES: String = "Cat Glasses"
    const val CAT_SHOES: String = "Cat Shoes"

    const val DOG_CLOTHES: String = "Dog Clothes"
    const val DOG_NECKBELT: String = "Dog Neck Belt"
    const val DOG_HAT: String = "Dog Hat"
    const val DOG_GLASSES: String = "Dog Glasses"
    const val DOG_SHOES: String = "Dog Shoes"

    const val CAT_HAIR_CUT: String = "Cat Hair Cut"
    const val CAT_NAIL_CUT: String = "Cat Nail Cut"
    const val CAT_HAIR_TREATMENT: String = "Cat Hair Treatment"

    const val DOG_HAIR_CUT: String = "Dog Hair Cut"
    const val DOG_NAIL_CUT: String = "Dog Nail Cut"
    const val DOG_HAIR_TREATMENT: String = "Dog Hair Treatment"



    fun showImageChooser(activity: Activity) {
        // An intent for launching the image selection of phone storage.
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        // Launches the image selection of phone storage using the constant code.
        activity.startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST_CODE)
    }

    fun getFileExtension(activity: Activity, uri: Uri?): String? {
        /*
         * MimeTypeMap: Two-way map that maps MIME-types to file extensions and vice versa.
         *
         * getSingleton(): Get the singleton instance of MimeTypeMap.
         *
         * getExtensionFromMimeType: Return the registered extension for the given MIME type.
         *
         * contentResolver.getType: Return the MIME type of the given content URL.
         */
        return MimeTypeMap.getSingleton()
            .getExtensionFromMimeType(activity.contentResolver.getType(uri!!))
    }
}