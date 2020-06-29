package com.benalmadena.activity.offers_discounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_osa_exchange.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityOsaExchange:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_osa_exchange,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        tv_latest_rate.setOnClickListener {
            goToWebViewScreen("","https://www.osacars.es/money-exchange-rates/")
        }
        tv_web.setOnClickListener {
            goToWebViewScreen("","https://www.osacars.es/money-exchange-rates/")
        }
    }

}