package com.benalmadena.activity.discover_benalmadena

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import kotlinx.android.synthetic.main.activity_discover_benalmaden.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityDiscoverBenalmaden :AppCompatActivity(){

    companion object{
        fun start(context: Context){
            val intent= Intent(context, ActivityDiscoverBenalmaden::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_benalmaden)

        tv_title.text="Discover Benalmadena"
        btn_back.setOnClickListener { finish() }

    }

    fun onDisvoverClicks(v:View){
        when(v){
            btn_history->{goToActivity(ActivityHistoryBenalmadena(),"History of Benalmadena")}
            btn_main_area->{goToActivity(ActivityMainAreas(),"Main Areas")}
            btn_facebbok->{
                ActivityWebView.start(this,"","https://www.facebook.com/discoverbenalmadena/")
            }
            btn_video->{
                goToActivity(ActivityVieoBenalmadena(),"Videos of Benalmadena")}

            btn_day_out_things->{goToActivity(ActivityDayOutThings(),"Days Out & Things to Do")}

            btn_local_news->{
                ActivityWebView.start(this,"","https://www.euroweeklynews.com/3.0.15/news/on-euro-weekly-news/costa-del-sol-malaga")
            }
            btn_public_transport->{
                goToActivity(ActivityPublicTransport(),"Public Transport")
            }
            btn_visitor_guide->{
                ActivityWebView.start(this,"","http://benalmadena-arroyo.com/")
            }
            btn_holiday_date->{}
            btn_weather->{}
        }
    }

    fun goToActivity(activity:AppCompatActivity,title:String){
        val intent= Intent(this,activity::class.java)
        intent.putExtra("title",title)
        startActivity(intent)
    }
}