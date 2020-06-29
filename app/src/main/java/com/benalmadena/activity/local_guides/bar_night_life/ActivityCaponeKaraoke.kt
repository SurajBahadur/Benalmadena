package com.benalmadena.activity.local_guides.bar_night_life

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*
import org.jetbrains.anko.makeCall

class ActivityCaponeKaraoke : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_capone_karaoke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        setFindUsValue()
    }

    fun setFindUsValue() {
        tv_address_find_us.text = "Av. Bonanza, Benalmadena Costa, Spain"
        tv_phone_find_us.text = " +34 627 47 49 16"
        ll_email.visibility = View.GONE
        ll_website.visibility = View.GONE

        tv_facebook_find_us.setOnClickListener {
            goToWebViewScreen("", "https://www.facebook.com/caponeskaraoke")
        }

        tv_phone_find_us.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    activity!!,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) run {
                ActivityCompat.requestPermissions(
                    this as Activity, arrayOf(
                        Manifest.permission.CALL_PHONE
                    ), 993
                )
            } else {
                activity!!.makeCall(" +34 627 47 49 16")
            }
        }
    }
}