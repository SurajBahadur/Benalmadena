package com.benalmadena.activity.local_guides.restaurants

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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

class ActivityLaNinaDelGurdia:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_la_lina_da_gurdia)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }
        setFindUsValue()

    }


    fun setFindUsValue(){
        tv_address_find_us.text="Avenida de la Constitución, 35, 29631 Benalmádena, Spain"
        tv_phone_find_us.text="+34 673 29 80 05"
        tv_email_find_us.text="benalmadenaexperience@hotmail.com"
        ll_website.visibility= View.GONE

        tv_facebook_find_us.setOnClickListener {
            ActivityWebView.start(this,"","https://www.facebook.com/laninadelguardia/")
        }
        tv_email_find_us.setOnClickListener {
            val mIntent = Intent(Intent.ACTION_SEND)
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(tv_email_find_us.text.toString()))

            try {
                //start email intent
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            }
            catch (e: Exception){
            }
        }

        tv_phone_find_us.setOnClickListener {
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
                makeCall(tv_phone_find_us.text.toString())

            }
        }
    }
}