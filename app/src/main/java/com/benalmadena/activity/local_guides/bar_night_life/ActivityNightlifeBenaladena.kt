package com.benalmadena.activity.local_guides.bar_night_life

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityNightlifeBenaladena:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nightlife_benaladena)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

    }
}