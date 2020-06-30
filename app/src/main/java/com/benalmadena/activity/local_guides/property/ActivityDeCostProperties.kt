package com.benalmadena.activity.local_guides.property

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityDeCostProperties:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_de_costa_properties,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        setFindUsValue()
    }


    fun setFindUsValue(){

        tv_address_find_us.text="11 Avd. Juan Luis Peralta, Benalmadena Pueblo, Malaga, 29639"
        tv_phone_find_us.text="34 952 586 426 "
        tv_email_find_us.text="sales@decostaproperties.com"
        tv_website_find_us.text="www.decostaproperties.com"
        tv_facebook_find_us.setOnClickListener {
            goToWebViewScreen("","https://www.facebook.com/De-Costa-Properties-194931867201487/")
        }
    }
}