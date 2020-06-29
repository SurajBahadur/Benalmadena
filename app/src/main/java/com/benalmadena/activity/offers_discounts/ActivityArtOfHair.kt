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

class ActivityArtOfHair :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_hair)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }


    fun setFindUsValue(){
        tv_address_find_us.text="Av. Inmaculada Concepcion 9, Arroyo de la Miel, Benalmádena, Spain 29631"
        tv_phone_find_us.text="+34 951 45 85 76"
        tv_email_find_us.text="info@artofhair.es"
        tv_website_find_us.text="www.artofhair.es"

        tv_email_find_us.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_SEND)
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@hotelpueblo.es"))

            try {
                //start email intent
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            }
            catch (e: Exception){
            }
        }
        tv_website_find_us.setOnClickListener {
            ActivityWebView.start(this,"","http://www.artofhair.es/")
        }
        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/Art-Of-Hair-362268654562980/")
        }
        tv_insta_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.instagram.com/artofhairnina/")
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
                makeCall("+34 951 45 85 76")

            }
        }

        ll_instagram.visibility= View.VISIBLE

    }
}