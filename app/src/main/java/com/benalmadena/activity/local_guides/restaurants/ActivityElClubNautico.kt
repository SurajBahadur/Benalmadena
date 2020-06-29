package com.benalmadena.activity.local_guides.restaurants

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*
import org.jetbrains.anko.makeCall

class ActivityElClubNautico:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_el_club_nautico,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        setFindUsValue()
    }


    fun setFindUsValue(){
        tv_address_find_us.text="Avda Juan Sebastian el Cano s/n, edf. Club Nautico 29630 Benalmadena"
        tv_phone_find_us.text="+34 633 332 604"
        tv_website_find_us.text="www.elclubnautico.es"

        ll_email.visibility= View.GONE

        tv_facebook_find_us.setOnClickListener {
            goToWebViewScreen("","https://www.facebook.com/ElClubNauticoRestaurantLounge")
        }

        tv_website_find_us.setOnClickListener {
            goToWebViewScreen("","http://www.elclubnautico.es/")
        }


        tv_phone_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(activity!!,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    this as Activity, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                activity!!.makeCall(tv_phone_find_us.text.toString())

            }
        }
    }
}