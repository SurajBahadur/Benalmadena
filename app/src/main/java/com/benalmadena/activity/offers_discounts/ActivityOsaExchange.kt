package com.benalmadena.activity.offers_discounts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_osa_exchange.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityOsaExchange:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_osa_exchange)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }
        tv_latest_rate.setOnClickListener {
            ActivityWebView.start(this,"","https://www.osacars.es/money-exchange-rates/")
        }
        tv_web.setOnClickListener {
            ActivityWebView.start(this,"","https://www.osacars.es/money-exchange-rates/")
        }
    }
}