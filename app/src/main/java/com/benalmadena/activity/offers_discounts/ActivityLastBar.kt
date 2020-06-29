package com.benalmadena.activity.offers_discounts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityLastBar:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_bar)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        setFindUsValue()
    }
    fun setFindUsValue() {
        tv_address_find_us.text = "avenida antonio machado 76 pueblo santa ana local 3, 29630 Benalmádena"
        ll_email.visibility = View.GONE
        ll_tel.visibility = View.GONE
        ll_website.visibility = View.GONE

        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this, "", "https://www.facebook.com/HereALast/")
        }
    }
}