package com.benalmadena.activity.offers_discounts

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*
import org.jetbrains.anko.makeCall

class ActivityCaramranCooper:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caramran_cooper)


        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }

    fun setFindUsValue(){
        tv_address_find_us.text="Puerto Marina, Berth 299"
        tv_telephone.text="Tel SPAIN"
        tv_mobile.text="Tel UK"
        tv_phone_find_us.text="689 63 53 39"
        tv_mob_find_us.text="+34 655 49 47 59"

        tv_email_find_us.text="benalmadenaexperience@hotmail.com"
        tv_website_find_us.text="www.benalmadenaexperience.com"
        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/Benalm%C3%A1dena-Experience-1602341396744908")
        }
        tv_website_find_us.setOnClickListener {
            ActivityWebView.start(this,"","http://www.benalmadenaexperience.com/")
        }
        tv_mob_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    this as Activity, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                makeCall("+34 655 49 47 59")

            }
        }
        tv_phone_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    this as Activity, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                makeCall("689 63 53 39")

            }
        }
        tv_email_find_us.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_SEND)
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("benalmadenaexperience@hotmail.com"))

            try {
                //start email intent
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            }
            catch (e: Exception){
            }
        }

        ll_mob.visibility= View.VISIBLE
    }
}