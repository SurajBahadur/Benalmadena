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

class ActivityElTorrenon:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_el_torrenon)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }


    fun setFindUsValue(){
        tv_address_find_us.text="Plaza la tribuna #11, Arroyo De La Miel, Andalucia, Spain 29631"
        tv_phone_find_us.text="+34 952 57 58 04"
        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/BAR-EL-TORREON-153828648021783/")
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
                makeCall("+34 952 57 58 04")

            }
        }
        ll_website.visibility= View.GONE
        ll_email.visibility= View.GONE

    }
}