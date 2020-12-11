package com.example.myapplication1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.models.User
import com.example.myapplication1.utils.Constants
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // TODO Step 5: Retrieve the User details from intent extra.
        // START
        // Create a instance of the User model class.
        var userDetails: User = User()
        if(intent.hasExtra(Constants.EXTRA_USER_DETAILS)) {
            // Get the user details from intent as a ParcelableExtra.
            userDetails = intent.getParcelableExtra(Constants.EXTRA_USER_DETAILS)!!
        }
        // END

        // TODO Step 6: After receiving the user details from intent set it to the UI.
        // START
        // Here, the some of the edittext components are disabled because it is added at a time of Registration.
        et_first_name.isEnabled = false
        et_first_name.setText(userDetails.firstName)

        et_last_name.isEnabled = false
        et_last_name.setText(userDetails.lastName)

        et_email.isEnabled = false
        et_email.setText(userDetails.email)
        // END

    }
}