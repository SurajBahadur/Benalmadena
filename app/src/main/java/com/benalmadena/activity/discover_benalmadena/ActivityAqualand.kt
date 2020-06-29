package com.benalmadena.activity.discover_benalmadena

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_aqualand.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityAqualand:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aqualand)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        tv_link_aqua.setOnClickListener {
            ActivityWebView.start(this,"","https://www.aqualand.es/")
        }
        img_aqua_map.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:36.625958, -4.508219")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }

}