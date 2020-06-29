package com.benalmadena.activity.offers_discounts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_register_offer.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityRegisterOffers:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_offer)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        tv_website.setOnClickListener {   ActivityWebView.start(this,"","http://www.discoverbenalmadena.info")
        }
    }
}