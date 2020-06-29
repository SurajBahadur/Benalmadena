package com.benalmadena.activity.offers_discounts

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
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

class ActivityFlamenco:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_famenco)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }

    fun setFindUsValue(){
        tv_address_find_us.text="7 Avenida Gamonal, Centro comercial Caranto 8, Benalmádena, Spain"
        tv_phone_find_us.text="+34 617 503 126"
        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/flamencobenalmadenapage/")
        }
        tv_insta_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.instagram.com/asamidebenal/")
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
                makeCall("+34 617 503 126")

            }
        }

        ll_instagram.visibility= View.VISIBLE
        ll_website.visibility= View.GONE
        ll_email.visibility= View.GONE

    }
}