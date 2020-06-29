package com.benalmadena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.benalmadena.activity.ActivityOffersDiscount
import com.benalmadena.activity.discover_benalmadena.ActivityDiscoverBenalmaden
import com.benalmadena.activity.local_guides.ActivityLocalGuidesServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onMainActivityClick(v:View){
        when(v){
            btn_offers_discount->{
                ActivityOffersDiscount.start(this)
            }
            btn_discover->{
                ActivityDiscoverBenalmaden.start(this)
            }
            btn_local_guid->{
                ActivityLocalGuidesServices.start(this)
            }
            btn_local_info->{

            }
            btn_radio->{

            }
        }
    }
}
