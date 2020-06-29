package com.benalmadena.activity.local_guides

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.bar_night_life.*
import com.benalmadena.activity.offers_discounts.ActivityKaraoke
import com.benalmadena.activity.offers_discounts.ActivityLaFiesta
import com.benalmadena.activity.offers_discounts.ActivityLastBar
import com.benalmadena.activity.offers_discounts.ActivityStanleyBar
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.activity_bars_nightlife.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityBarsNightlife:AppCompatActivity() {

    lateinit var adapterBarNightLife: AdapterBarNightLife
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bars_nightlife)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }
        initRecyclerView()
    }

    fun initRecyclerView() {
        val listData=ArrayList<BarNightLife>()
        listData.add(BarNightLife("Bars & Nightlife in Benalmadena",R.drawable.bars_nightlife_1,
            ActivityNightlifeBenaladena(),"",1))
        listData.add(BarNightLife("The Black Bull Olde Tavern",R.drawable.img_3,
            ActivityTheBlackBull(),"",1))
        listData.add(BarNightLife("Stanley's",R.drawable.img_7,ActivityStanleyBar(),"",1))

        listData.add(BarNightLife("Bar La Fiesta",R.drawable.img_3,ActivityLaFiesta(),"",1))
        listData.add(BarNightLife("Here at Last",R.drawable.img_3, ActivityHereAtLast(),"",1))

        listData.add(BarNightLife("Capone's Karaoke & Music Bar",R.drawable.img_10,
            ActivityCaponeKaraoke(),"",1))
        listData.add(BarNightLife("Taberna Flamenca Pepe López",R.drawable.img_13,
            ActivityTabernaFlamenca(),"",1))
        listData.add(BarNightLife("Casino Torrequebrada",R.drawable.bars_nightlife_2,ActivityBarsNightlife(),"http://www.casinotorrequebrada.com/",2))
        listData.add(BarNightLife("Tivoli World Late Nights",R.drawable.discover_4,ActivityBarsNightlife(),"http://www.tivoli.es/",2))




        adapterBarNightLife= AdapterBarNightLife(this,listData)
        rv_bar_night_life.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_bar_night_life.adapter = adapterBarNightLife

    }
}