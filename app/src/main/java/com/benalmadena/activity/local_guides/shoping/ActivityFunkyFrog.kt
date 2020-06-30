package com.benalmadena.activity.local_guides.shoping

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
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

class ActivityFunkyFrog :BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_funny_frog,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        setFindUsValue()
    }


    fun setFindUsValue(){
        tv_address_find_us.text="Ada. Gamonal (Opp Hercules) - Arroyo de la Miel (Malaga)"
        tv_phone_find_us.text="+34 678 23 76 90"
        tv_mob_find_us.text="+34 952 44 66 43"
        tv_email_find_us.text="dee.funkyfrog@gmail.com"
        tv_website_find_us.text="www.dizzycards.com"
        ll_mob.visibility=View.VISIBLE
        ll_email.visibility=View.VISIBLE
        ll_website.visibility=View.VISIBLE

        tv_website_find_us.setOnClickListener {
            goToWebViewScreen("", "http://www.dizzycards.com")
        }
        tv_facebook_find_us.setOnClickListener {
            goToWebViewScreen("","https://www.facebook.com/Funky-Frog-Greetings-Cards-215920031787005/")
        }
        tv_phone_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    activity!!, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                activity!!.makeCall("+34 678 23 76 90")

            }
        }
        tv_mob_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    activity!!, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                activity!!.makeCall(tv_mob_find_us.text.toString())

            }
        }

    }
}