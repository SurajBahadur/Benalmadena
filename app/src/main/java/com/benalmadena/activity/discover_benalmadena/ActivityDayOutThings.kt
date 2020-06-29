package com.benalmadena.activity.discover_benalmadena

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_dayo_out.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityDayOutThings:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dayo_out)

        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

    }

    fun onDayOutClick(v:View){
        when(v){
            btn_tivoli_world->{
                ActivityWebView.start(this,"","www.tivoli.es/")
            }
            btn_aqualand->{

                val intent= Intent(this,ActivityAqualand::class.java)
                intent.putExtra("title","Aqualand")
                startActivity(intent)
            }
            btn_selwo->{

                ActivityWebView.start(this,"","http://selwomarina.es/en")
            }
            btn_calecar->{
                ActivityWebView.start(this,"","http://telefericobenalmadena.com/?lang=en")
            }
            btn_sunset_beach->{
                ActivityWebView.start(this,"","http://www.sunsetbeachwatersports.com/")
            }
            btn_sealife->{

                ActivityWebView.start(this,"","https://www.visitsealife.com/benalmadena/en/")
            }

            btn_butterfly->{

                ActivityWebView.start(this,"","http://www.mariposariodebenalmadena.com/en/")
            }
            btn_ek_ranchito->{

                ActivityWebView.start(this,"","http://ranchito.com/")
            }
            btn_tourist_train->{

                ActivityWebView.start(this,"","https://www.tripadvisor.co.uk/Attraction_Review-g1079250-d4995165-Reviews-Moncho_Tren_S_A-Arroyo_de_la_Miel_Benalmadena_Costa_del_Sol_Province_of_Malaga_A.html#REVIEWS")
            }
            btn_ferry_curise->{

                ActivityWebView.start(this,"","http://www.costasolcruceros.com/")
            }
        }
    }
}