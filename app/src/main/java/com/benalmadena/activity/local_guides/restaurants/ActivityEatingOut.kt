package com.benalmadena.activity.local_guides.restaurants

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import kotlinx.android.synthetic.main.activity_eating_out.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityEatingOut:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eating_out)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        btn_eat_map.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:36.592448, -4.545636")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }
}