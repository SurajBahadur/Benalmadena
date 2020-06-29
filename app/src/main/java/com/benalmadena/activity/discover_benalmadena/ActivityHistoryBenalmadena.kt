package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityHistoryBenalmadena:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_benalmadena)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

    }

}