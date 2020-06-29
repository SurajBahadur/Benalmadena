package com.benalmadena.activity.discover_benalmadena.main_areas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_arroyo.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityArroyo:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arroyo)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        link_1_arroy.setOnClickListener {
            ActivityWebView.start(this,"",link_1_arroy.text.toString())
        }
    }
}