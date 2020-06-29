package com.benalmadena.activity.offers_discounts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_register_offer.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityRegisterOffers : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_register_offer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        tv_website.setOnClickListener {
            goToWebViewScreen("", "http://www.discoverbenalmadena.info")
        }

    }


}