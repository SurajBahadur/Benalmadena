package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_public_transport.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityPublicTransport:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_public_transport)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        link_1_tranport.setOnClickListener {
            ActivityWebView.start(this,"","http://www.avanzabus.com/web/timetables/desde-benalmadena-todos-los-destinos-bus-timetables.html")
        }
        link_2_tranport.setOnClickListener {
            ActivityWebView.start(this,"","http://benalmadena-arroyo.com/train-timetable.php")

        }
    }
}