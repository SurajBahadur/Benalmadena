package com.benalmadena.activity.discover_benalmadena.main_areas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_benalmadena_costa.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityBenalmadenaCosta:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benalmadena_costa)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        link_1.setOnClickListener {
            ActivityWebView.start(this,"",link_1.text.toString())
        }
        link_2.setOnClickListener {
            ActivityWebView.start(this,"",link_2.text.toString())
        }
        link_3.setOnClickListener {
            ActivityWebView.start(this,"",link_3.text.toString())
        }
    }
}