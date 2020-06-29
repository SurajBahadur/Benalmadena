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

class ActivityOsaCarHire:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_osa_car_hire)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }

    fun setFindUsValue(){
        tv_address_find_us.text= resources.getString(R.string.osa_adress)
        tv_phone_find_us.text="+34 952 560 795"
        tv_mob_find_us.text="+34 635 248 811"
        tv_website_find_us.text="www.osacars.es"
        tv_website_find_us.setOnClickListener {

            ActivityWebView.start(this,"","http://www.osacars.es/")
        }
        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/osacarsrentacar/")
        }


        tv_phone_find_us.setOnClickListener {
            makeCallUser("+34 952 560 795")
        }
        ll_email.visibility= View.GONE
        ll_mob.visibility= View.GONE

    }
    fun makeCallUser(no:String){
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
            makeCall(no)

        }
    }
}