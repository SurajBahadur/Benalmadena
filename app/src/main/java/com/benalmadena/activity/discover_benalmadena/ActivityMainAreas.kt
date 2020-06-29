package com.benalmadena.activity.discover_benalmadena

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityArroyo
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityBenalmadenaCosta
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityBenalmadenaPueblo
import kotlinx.android.synthetic.main.activity_main_areas.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityMainAreas:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_areas)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        btn_costa.setOnClickListener { goToActivity(ActivityBenalmadenaCosta(),"Benalmadena Costa") }
        btn_arroyo.setOnClickListener {  goToActivity(ActivityArroyo(),"Arroyo de la Miel")  }
        btn_pueblo.setOnClickListener {  goToActivity(ActivityBenalmadenaPueblo(),"Benalmaden Pueblo")  }

    }

    fun goToActivity(activity:AppCompatActivity,title:String){
        val intent= Intent(this,activity::class.java)
        intent.putExtra("title",title)
        startActivity(intent)
    }
}